/**
 * Created by sergeytoropov on 01.03.17.
 */
public class Ext2 implements HelloWorld  {
    HelloWorld hw = new Base();

    public String make() {
        return hw.make() + hw.make();
    }
}
