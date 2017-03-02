import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.*;

/**
 * Created by sergeytoropov on 01.03.17.
 */
public class Launcher {
    private static final String base = "base";
    private static final String baseExt1 = "baseExt1";
    private static final String baseExt2 = "baseExt2";
    private static final String baseExt1Ext2 = "baseExt1Ext2";

    public static File getFile(String location) throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources(location);
        for (Resource r: resources) {
            return r.getFile();
        }
        throw new UnsupportedOperationException("Инициализационный файл app.properties не найден.");
    }

    public static String getActiveModules(String location) {
        String modules = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(getFile(location)));
            modules = reader.readLine();
            reader.close();

            if ("modules=base".equals(modules)) {
                return base;
            } else if ("modules=base,ext1".equals(modules)) {
                return baseExt1;
            } else if ("modules=base,ext2".equals(modules)) {
                return baseExt2;
            } else if ("modules=base,ext1,ext2".equals(modules)) {
                return baseExt1Ext2;
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        throw new UnsupportedOperationException("Неподдерживаемый порядок загрузки модулей. Порядок [" + modules + "].");
    }

    public static void printBeans(ConfigurableApplicationContext appCtx) {
        System.out.println("Beans:");
        for (String beanName: appCtx.getBeanDefinitionNames()) {
            System.out.println("    " + beanName);
        }
    }

    public static void main(String[] args) {
        String activeModules = getActiveModules("classpath:app/app.properties");

        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        appCtx.getEnvironment().setActiveProfiles(activeModules);
        appCtx.refresh();

        //printBeans(appCtx);

        Program program = appCtx.getBean(Program.class);
        program.run();

        appCtx.close();
    }
}
