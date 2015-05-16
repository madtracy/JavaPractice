package tracy.basic.extendz;

/**
 * User: tracy
 * Time: 2015/5/16 20:28
 */


public class HelloB extends HelloA {
    public HelloB() {
        System.out.println("HelloB");
    }

    { System.out.println("Class B"); }

        static { System.out.println("Static B"); }

    public static void main(String[] args) {
        new HelloB();
    }
    /* output:
    Static A
    Static B
    Class A
    HelloA
    Class B
    HelloB
     */
}

