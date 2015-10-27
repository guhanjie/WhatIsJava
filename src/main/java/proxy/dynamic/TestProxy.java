package proxy.dynamic;

import java.lang.reflect.InvocationHandler;

/**
 * Created by Liuxey on 2015/10/27.
 */
public class TestProxy {

    public static void main(String[] args) {
        UserServiceImpl target = new UserServiceImpl();
        InvocationHandler proxy = new LogProxy(target);
        UserService userService = ProxyFactory.newProxy(target, proxy);
        userService.add("jack");
        userService.delete("jack");
    }
}
