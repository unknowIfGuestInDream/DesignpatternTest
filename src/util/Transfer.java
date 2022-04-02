package util;

/**
 * java值传递
 *
 * @author: 唐 亮
 * @date: 2022/4/2 20:24
 * @since: 1.0
 */
public class Transfer {

    public static void main(String[] args) {
        String a = "Hello";
        link(a);
        System.out.println(a);
    }

    public static void link(String a) {
        a += "World";
    }

}
