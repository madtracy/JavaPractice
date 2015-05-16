package tracy.design.patterns.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * User: tracy
 * Time: 2015/5/13 17:20
 */
public class DynamicProxyHandler implements InvocationHandler {

    Object proxied;
    public DynamicProxyHandler(Object proxied){
        this.proxied=proxied;
    }

    public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{
        System.out.println("**** proxy: "+proxy.getClass() + ", method: "+method+",arg: " +args);
        if(args!=null)
            for(Object arg : args){
                System.out.println(" "+arg);
            }
        return method.invoke(proxied,args);
    }


    public static void main(String[] args) {
        RealObject real = new RealObject();
        Foo proxy = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),new Class[]{Foo.class},new DynamicProxyHandler(real));
        proxy.doSomething();
        proxy.doSomethingElse("bonobo");
    }
}
