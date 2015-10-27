package proxy.dynamic;

/**
 * Created by Liuxey on 2015/10/27.
 */
public class UserServiceImpl implements UserService {

    @Override
    public void add(String username) {
        System.out.println("User:" + username + " added.");
    }

    @Override
    public void delete(String username) {
        System.out.println("User:" + username + " deleted.");
    }
}
