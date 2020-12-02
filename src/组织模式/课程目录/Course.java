package 组织模式.课程目录;

/**
 * 课程类
 *
 * @author: TangLiang
 * @date: 2020/12/2 15:58
 * @since: 1.0
 */
public class Course extends CourseComponent {
    private String name;
    private double price;

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(CourseComponent courseComponent) {
        return this.name;
    }

    @Override
    public double getPrice(CourseComponent courseComponent) {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println(name + " (￥" + price + "元)");
    }
}
