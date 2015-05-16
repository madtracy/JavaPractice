package tracy.basic.extendz;

/**
 * User: tracy
 * Time: 2015/5/16 20:37
 */
public class HelloA {
    public HelloA() {
        System.out.println("HelloA");
    }

    { System.out.println("Class A"); }

    static { System.out.println("Static A"); }
}
