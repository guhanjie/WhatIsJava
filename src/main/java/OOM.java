/**
 * Created by ShaoJin on 2014/12/19 0019.
 */
public class OOM {

    static int length = 0;

    public static void main(String[] args) {
        nest();
    }


    public static void nest() {
        length++;
        try {
            nest();

        } catch (Throwable e) {
            System.out.println("StackLength:" + length);
            e.printStackTrace();
        }
    }
}
