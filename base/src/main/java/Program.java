import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergeytoropov on 02.03.17.
 */
public class Program {
    private final HelloWorld hw;
    private final List<Description> listDescription = new ArrayList<>();

    public Program(HelloWorld hw, Description base) {
        this.hw = hw;
        this.listDescription.add(base);
    }

    public Program(HelloWorld hw, Description base, Description ext) {
        this(hw, base);
        this.listDescription.add(ext);
    }

    public Program(HelloWorld hw, Description base, Description ext1, Description ext2) {
        this(hw, base, ext1);
        this.listDescription.add(ext2);
    }

    public void run() {
        System.out.println("Modules:");
        listDescription.stream().forEach(System.out::println);

        System.out.println("Result string:");
        System.out.println("    " + hw.make());

        System.out.println("Descriptions:");
        listDescription.stream().forEach(description -> description.print());
    }
}
