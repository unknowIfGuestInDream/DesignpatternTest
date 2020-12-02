package 门面模式.整合已知API功能;

/**
 * 物流系统
 *
 * @author: TangLiang
 * @date: 2020/12/2 9:28
 * @since: 1.0
 */
public class ShippingService {

    //发货
    public String delivery(GiftInfo giftInfo) {
        //物流系统对接逻辑
        System.out.println(giftInfo.getName() + "进入物流系统");
        String shippingOrderNo = "666";
        return shippingOrderNo;
    }
}
