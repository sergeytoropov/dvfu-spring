import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * Created by sergeytoropov on 02.03.17.
 */
public class DescriptionImpl implements Description {
    protected final String moduleName;
    protected final String moduleDescription;

    protected DescriptionImpl(String moduleName, String moduleDescription) {
        this.moduleName = moduleName;
        this.moduleDescription = moduleDescription;
    }

    @Override
    public void print() {
        System.out.println("Description: " + moduleDescription + "\n");

        System.out.println("List:");
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources;
        try {
            resources = resolver.getResources("file:" + moduleName + "/**/resources/" + moduleName + "/*");
            for (Resource r: resources) {
                System.out.println("    " + r.getFilename());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "    " + moduleName;
    }
}
