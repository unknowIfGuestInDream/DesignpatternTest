package 委派模式.任务分配场景;

/**
 * @author: TangLiang
 * @date: 2021/2/5 13:36
 * @since: 1.0
 */
public class Test {
    public static void main(String[] args) {
        new Boss().commmand("海报图", new Leader());
        new Boss().commmand("爬虫", new Leader());
        new Boss().commmand("卖手机", new Leader());
    }
}
