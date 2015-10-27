package proxy.cglib;

/**
 * Created by Liuxey on 2015/10/27.
 */
public class UserService {

    public void add(String username) {
        System.out.println("User:" + username + " added.");
    }

    public void delete(String username) {
        System.out.println("User:" + username + " deleted.");
    }
}
