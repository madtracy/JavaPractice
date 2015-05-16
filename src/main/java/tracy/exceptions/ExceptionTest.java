package tracy.exceptions;

/**
 * User: tracy
 * Time: 2015/5/16 15:00
 */
public class ExceptionTest {
    public static void main(String [] args) {
        try {
            badMethod();
            System.out.println("1");
        } catch (RuntimeException e) {
            System.out.println("2");
        } finally {
            System.out.println("3");
        }
        System.out.println("4");
    }
    public static void badMethod() {
        throw new NullPointerException();
    }
}
