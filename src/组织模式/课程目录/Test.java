package 组织模式.课程目录;

/**
 * @author: TangLiang
 * @date: 2020/12/2 16:05
 * @since: 1.0
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("========透明组合模式========");

        CourseComponent javaBase = new Course("Java入门课程", 82);
        CourseComponent ai = new Course("人工智能", 150);

        CourseComponent packageCourse = new CoursePackage("Java学习之路", 2);

        CourseComponent design = new Course("Java设计模式", 50);
        CourseComponent source = new Course("Java源码分析", 200);
        CourseComponent softkill = new Course("Java实战", 88);

        packageCourse.addChild(design);
        packageCourse.addChild(source);
        packageCourse.addChild(softkill);

        CourseComponent catalog = new CoursePackage("课程主目录", 1);
        catalog.addChild(javaBase);
        catalog.addChild(ai);
        catalog.addChild(packageCourse);

        catalog.print();

    }
}
