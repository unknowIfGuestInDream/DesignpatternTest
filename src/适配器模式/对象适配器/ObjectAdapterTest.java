package 适配器模式.对象适配器;

/**
 * 对象适配器
 *
 * @author: TangLiang
 * @date: 2021/2/5 22:05
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

//对象适配器类
class ObjectAdapter implements Target {
    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        adaptee.specificRequest();
    }
}

//客户端代码
public class ObjectAdapterTest {
    public static void main(String[] args) {
        System.out.println("对象适配器模式测试：");
        Adaptee adaptee = new Adaptee();
        Target target = new ObjectAdapter(adaptee);
        target.request();
    }
}
