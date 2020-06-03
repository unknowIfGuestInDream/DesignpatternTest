package 策略模式;

/**
 * @author: TangLiang
 * @date: 2020/6/3 15:58
 * @since: 1.0
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void show(){
        this.strategy.show();
    }
}
