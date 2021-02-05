package 适配器模式.类适配器;

/**
 * 类适配器
 *
 * @author: TangLiang
 * @date: 2021/2/5 22:03
 * @since: 1.0
 */
//目标接口
interface Target {
    void request();
}

//适配者接口
class Adaptee {
    public void specificRequest() {
        System.out.println("适配者中的业务代码被调用！");
    }
}

//类适配器类
class ClassAdapter extends Adaptee implements Target {
    public void request() {
        specificRequest();
    }
}

//客户端代码
public class ClassAdapterTest {
    public static void main(String[] args) {
        System.out.println("类适配器模式测试：");
        Target target = new ClassAdapter();
        target.request();
    }
}
