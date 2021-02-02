package 状态模式;

/**
 * 状态模式通用写法
 *
 * @author: TangLiang
 * @date: 2021/2/1 13:49
 * @since: 1.0
 */
public class Client {

    //抽象状态
    interface IState {
        void handle();
    }

    //具体状态类
    static class ConcreteStateA implements IState {

        @Override
        public void handle() {
            System.out.println("StateA do action");
        }
    }

    //具体状态类
    static class ConcreteStateB implements IState {

        @Override
        public void handle() {
            System.out.println("StateB do action");
        }
    }

    //环境类
    static class Context {
        private static final IState STATE_A = new ConcreteStateA();
        private static final IState STATE_B = new ConcreteStateB();
        //默认状态A
        private IState currentState = STATE_A;

        public void setState(IState state) {
            this.currentState = state;
        }

        public void handle() {
            this.currentState.handle();
        }
    }

    public static void main(String[] args) {
        Context context=new Context();
        context.setState(new ConcreteStateB());
        context.handle();
    }

}
