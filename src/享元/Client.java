package 享元;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: TangLiang
 * @date: 2020/9/27 14:17
 * @since: 1.0
 */
public class Client {

    public static void main(String[] args) {
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        IFlyweight flyweight1 = FlyweightFactory.getFlyweight("aa");
        IFlyweight flyweight2 = FlyweightFactory.getFlyweight("bb");
        flyweight1.operation("a");
        flyweight2.operation("b");
    }

    interface IFlyweight {
        void operation(String extrinsicState);
    }

    //具体享元角色
    static class ConcreteFlyweight implements IFlyweight {

        private String intrinsicState;

        public ConcreteFlyweight(String intrinsicState) {
            this.intrinsicState = intrinsicState;
        }

        @Override
        public void operation(String extrinsicState) {
            System.out.println("Object address: " + System.identityHashCode(this));
            System.out.println("IntrinsicState: " + this.intrinsicState);
            System.out.println("ExtrinsicState: " + extrinsicState);
        }
    }

    //享元工厂
    static class FlyweightFactory {
        private static Map<String, IFlyweight> pool = new HashMap<>();

        //因为内部状态具有不变性,所以作为缓存的键
        public static IFlyweight getFlyweight(String intrinsicState) {
            if (!pool.containsKey(intrinsicState)) {
                IFlyweight flyweight = new ConcreteFlyweight(intrinsicState);
                pool.put(intrinsicState, flyweight);
            }
            return pool.get(intrinsicState);
        }
    }

}
