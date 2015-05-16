package tracy.design.patterns.dynamicproxy;

/**
 * User: tracy
 * Time: 2015/5/13 17:26
 */
public class RealObject implements Foo {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void doSomethingElse(String arg) {
        System.out.println("somethingElse "+arg);
    }
}
