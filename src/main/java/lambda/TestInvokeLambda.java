package lambda;

/**
 * Created by Liuxey on 2015/7/31.
 */
public class TestInvokeLambda {

    public static void main(String[] args) {
        String value = invoke((v) ->  v.toUpperCase(), "abc");
        String value2 = invoke(String::toUpperCase, "abc");
        System.out.println(value);
        System.out.println(value2);
    }

    public static String invoke(Switcher switcher, String val) {

        return switcher.apply(val);
    }
}
