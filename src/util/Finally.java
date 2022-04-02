package util;

/**
 * 测试finally
 *
 * @author: 唐 亮
 * @date: 2022/4/2 20:22
 * @since: 1.0
 */
public class Finally {

    public static void main(String[] args) {
        System.out.println(finallyTest());
    }

    public static int finallyTest() {
        try {
            System.out.println(1);
            return 1;
        } catch (Exception e) {
            System.out.println(2);
            return 2;
        } finally {
            System.out.println(3);
            return 3;
        }
    }

}
