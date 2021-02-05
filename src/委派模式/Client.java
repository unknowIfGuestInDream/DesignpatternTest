package 委派模式;

import java.util.Random;

/**
 * 通用写法
 *
 * @author: TangLiang
 * @date: 2021/2/3 17:21
 * @since: 1.0
 */
public class Client {
    public static void main(String[] args) {
        new Delegate().doTask();
    }

    //抽象任务角色 定义一个抽象接口，它有若干实现类
    interface Task {
        void doTask();
    }

    //具体任务角色A 真正执行任务的角色
    static class ConcreteA implements Task {

        @Override
        public void doTask() {
            System.out.println("执行,由A实现");
        }
    }

    //具体任务角色B
    static class ConcreteB implements Task {

        @Override
        public void doTask() {
            System.out.println("执行,由B实现");
        }
    }

    //委派者角色 负责在各个角色实例中做出决策，判断并调用具体实现的方法
    static class Delegate implements Task {

        @Override
        public void doTask() {
            System.out.println("代理执行开始");

            Task task = null;
            if (new Random().nextBoolean()) {
                task = new ConcreteA();
                task.doTask();
            } else {
                task = new ConcreteB();
                task.doTask();
            }
            System.out.println("代理执行完毕");
        }
    }


}
