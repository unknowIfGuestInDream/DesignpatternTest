package 基础.异或;

/**
 * @author: TangLiang
 * @date: 2021/7/13 21:26
 * @since: 1.0
 */
public class main {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        //不加任何变量的情况下 ab互换
        //原文 + 密钥=密文 + 密钥 = 原文
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        //System.out.println(Math.addExact(2147483647, 1));
        System.out.println("a: " + a);
        System.out.println("b: " + b);

        System.out.println('a' ^ 32);
        char chars = 'b';
        chars ^= 32;
        System.out.println(chars);

        //https://www.cnblogs.com/shuaiding/p/11124974.html
        //JavaScript 中调用 Java
    }
}
