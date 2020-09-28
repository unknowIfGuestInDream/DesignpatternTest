package 享元.火车票;

import java.util.Random;

/**
 * @author: TangLiang
 * @date: 2020/9/27 14:32
 * @since: 1.0
 */
public class TrainTicket implements ITicket {
    private String from;
    private String to;
    private int price;

    public TrainTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void showInfo(String bunk) {
        this.price = new Random().nextInt(500);
        System.out.println(String.format("%s->%s: %s 价格: %s 元", this.from, this.to, bunk, this.price));
    }
}
