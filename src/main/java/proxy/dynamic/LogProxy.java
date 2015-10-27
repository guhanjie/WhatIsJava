package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Liuxey on 2015/10/27.
 */
public class LogProxy implements InvocationHandler {

    private Object target;

    public LogProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("++++++++++++++++++++++++++Invoke start: " + method.getName());
        result = method.invoke(target, args);
        System.out.println("++++++++++++++++++++++++++END");
        return result;
    }
}
