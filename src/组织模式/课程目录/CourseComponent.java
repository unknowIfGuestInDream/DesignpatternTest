package 组织模式.课程目录;

/**
 * @author: TangLiang
 * @date: 2020/12/2 15:53
 * @since: 1.0
 */
public abstract class CourseComponent {
    public void addChild(CourseComponent courseComponent) {
        throw new UnsupportedOperationException("不支持添加操作");
    }

    public void removeChild(CourseComponent courseComponent) {
        throw new UnsupportedOperationException("不支持删除操作");
    }

    public String getName(CourseComponent courseComponent) {
        throw new UnsupportedOperationException("不支持获取名称操作");
    }

    public double getPrice(CourseComponent courseComponent) {
        throw new UnsupportedOperationException("不支持获取价格操作");
    }

    public void print() {
        throw new UnsupportedOperationException("不支持打印操作");
    }

}
