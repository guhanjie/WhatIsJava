package lambda;

/**
 * Created by Liuxey on 2015/7/31.
 */
@FunctionalInterface
public interface Switcher {

    String apply(String val);
}
