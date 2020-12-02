package 门面模式.整合已知API功能;

/**
 * 积分系统
 *
 * @author: TangLiang
 * @date: 2020/12/2 9:25
 * @since: 1.0
 */
public class QualifyService {
    public boolean isAvailable(GiftInfo giftInfo) {
        System.out.println("校验" + giftInfo.getName() + " 积分资格通过，库存通过");
        return true;
    }
}
