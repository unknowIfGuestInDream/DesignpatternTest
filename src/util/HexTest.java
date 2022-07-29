package util;

/**
 * @author: 唐 亮
 * @date: 2022/7/21 6:21
 * @since: 1.0
 */
public class HexTest {

    public static void main(String[] args) {
        String hex = "80000000";
        double d = 0;
        try {
            d = Integer.parseInt(hex, 16);
        } catch (Exception e) {
            System.out.println(hex);
            System.out.println(d);
        }
        System.out.println(d);
    }
}
