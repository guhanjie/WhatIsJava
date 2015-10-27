package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * Created by Liuxey on 2015/10/27.
 */
public class ProxyFactory {

    public static <T> T newProxy(T t, MethodInterceptor proxy) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(t.getClass());
        enhancer.setCallback(proxy);
        return (T) enhancer.create();
    }
}
