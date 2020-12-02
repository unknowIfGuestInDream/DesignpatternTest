package 组织模式.课程目录;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: TangLiang
 * @date: 2020/12/2 15:56
 * @since: 1.0
 */
public class CoursePackage extends CourseComponent {
    private List<CourseComponent> items = new ArrayList<>();
    private String name;
    private Integer level;

    public CoursePackage(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void addChild(CourseComponent courseComponent) {
        items.add(courseComponent);
    }

    @Override
    public String getName(CourseComponent courseComponent) {
        return this.name;
    }

    @Override
    public void removeChild(CourseComponent courseComponent) {
        items.remove(courseComponent);
    }

    @Override
    public void print() {
        System.out.println(this.name);
        for (CourseComponent catalogComponent : items) {
            //控制显示格式、
            if (this.level != null) {
                for (int i = 0; i < this.level; i++) {
                    //打印空格控制格式
                    System.out.print("  ");
                }
                for (int i = 0; i < this.level; i++) {
                    //每一行开始打印一个+
                    if (i == 0) System.out.print("+");
                    System.out.print("-");
                }
            }
            //打印标题
            catalogComponent.print();
        }
    }
}
