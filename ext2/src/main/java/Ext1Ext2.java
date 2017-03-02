import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by sergeytoropov on 01.03.17.
 */
//@Repository
//@Scope("Prototype")
public class Ext1Ext2 implements HelloWorld {
    HelloWorld hw = new Ext1();

    public String make() {
        return hw.make() + hw.make();
    }
}
