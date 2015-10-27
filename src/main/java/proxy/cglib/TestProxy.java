package proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;

/**
 * Created by Liuxey on 2015/10/27.
 */
public class TestProxy {

    public static void main(String[] args) {
        UserService userService = new UserService();
        MethodInterceptor handler = new LogProxy(userService);
        UserService proxy = ProxyFactory.newProxy(userService, handler);
        proxy.add("jack");
        proxy.delete("jack");
    }
}
