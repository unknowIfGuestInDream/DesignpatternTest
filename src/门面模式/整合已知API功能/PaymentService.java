package 门面模式.整合已知API功能;

/**
 * 支付系统
 *
 * @author: TangLiang
 * @date: 2020/12/2 9:26
 * @since: 1.0
 */
public class PaymentService {
    public boolean pay(GiftInfo pointGift) {
        //扣减积分
        System.out.println("支付" + pointGift.getName() + " 积分成功");
        return true;
    }
}
