package 桥接模式;

/**
 * @author: TangLiang
 * @date: 2021/2/18 10:24
 * @since: 1.0
 */
public class Client {
    public static void main(String[] args) {
        //创建一个具体角色
        IImplementor imp = new ConcreteImplementorA();
        //创建一个抽象角色，聚合实现
        Abstraction abs = new RefinedAbstraction(imp);
        //执行操作
        abs.operation();
    }

    /*
    该类持有一个对实现角色的引用，抽象角色中的方法需要实现角色来实现。
    抽象角色一般为抽象类（构造函数规定子类传入一个实现对象）。
     */
    //抽象
    static abstract class Abstraction {
        protected IImplementor implementor;

        public Abstraction(IImplementor implementor) {
            this.implementor = implementor;
        }

        public void operation() {
            this.implementor.operationImpl();
        }
    }

    /*
    Abstraction的具体实现，对Abstraction的方法进行完善和扩展
     */
    //修正抽象
    static class RefinedAbstraction extends Abstraction {

        public RefinedAbstraction(IImplementor implementor) {
            super(implementor);
        }

        @Override
        public void operation() {
            super.operation();
            System.out.println("refined operation");
        }
    }

    /*
    确定实现维度的基本操作，提供给Abstraction使用。该类一般为接口或抽象类。
     */
    //抽象实现
    interface IImplementor {
        void operationImpl();
    }

    /*
    IImplementor的具体实现
     */
    //具体实现
    static class ConcreteImplementorA implements IImplementor {

        @Override
        public void operationImpl() {
            System.out.println("I'm ConcreteImplementor A");
        }
    }

    //具体实现
    static class ConcreteImplementorB implements IImplementor {

        @Override
        public void operationImpl() {
            System.out.println("I'm ConcreteImplementor B");
        }
    }

}
