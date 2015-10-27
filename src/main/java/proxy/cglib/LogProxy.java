package proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Liuxey on 2015/10/27.
 */
public class LogProxy implements MethodInterceptor{

    private Object target;

    public LogProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        System.out.println("++++++++++++++++++++++++++Invoke start: " + method.getName());
        result = method.invoke(target, objects);
        System.out.println("++++++++++++++++++++++++++END");
        return result;
    }
}
