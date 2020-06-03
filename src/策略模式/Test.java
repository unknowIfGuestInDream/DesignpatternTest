package 策略模式;

/**
 * @author: TangLiang
 * @date: 2020/6/3 15:56
 * @since: 1.0
 */
public class Test {
    public static void main(String[] args) {
        //选择一个具体策略
        Strategy strategy = new Strategy1();
        //来一个上下文环境
        Context context = new Context(strategy);
        context.show();
    }
}
