/**
 * Created by sergeytoropov on 01.03.17.
 */
public class Ext2 implements HelloWorld  {
    private HelloWorld hw;

    public String make() {
        return hw.make() + hw.make();
    }

    public void setHelloWorld(HelloWorld hw) {
        this.hw = hw;
    }
}
