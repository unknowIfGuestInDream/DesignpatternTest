package util;

/**
 * java值传递
 *
 * @author 唐亮
 * @date 17:14 2021/3/25
 * @return
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer v1 = new Integer(1);
        Integer v2 = v1;
        System.out.println(v1 == v2);
        System.out.println(v2.intValue());
        v2 = new Integer(2);
        System.out.println(v1 == v2);
        System.out.println(v2.intValue());
    }
}
