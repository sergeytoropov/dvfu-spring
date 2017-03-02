/**
 * Created by sergeytoropov on 01.03.17.
 */
public class Ext1 implements HelloWorld {
    private HelloWorld hw;

    public String make() {
        return hw.make().toUpperCase();
    }

    public void setHelloWorld(HelloWorld hw) {
        this.hw = hw;
    }
}
