package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Liuxey on 2015/10/27.
 */
public class ProxyFactory {

    public static <T> T newProxy(T t, InvocationHandler proxy) {
        return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), proxy);
    }
}
