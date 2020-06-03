package 反射赋值;

/**
 * @author: TangLiang
 * @date: 2020/6/3 10:02
 * @since: 1.0
 */
public class Test {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student();
        Tool t = new Tool();
        t.setProperty(student, "name", "唐大");
        System.out.println(student.toString());
    }
}
