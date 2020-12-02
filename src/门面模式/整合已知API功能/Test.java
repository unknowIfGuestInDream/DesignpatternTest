package 门面模式.整合已知API功能;

/**
 * @author: TangLiang
 * @date: 2020/12/2 9:33
 * @since: 1.0
 */
public class Test {
    public static void main(String[] args) {
        GiftInfo giftInfo = new GiftInfo("《Hello 门面模式》");
        GiftFacadeService giftFacadeService = new GiftFacadeService();
        giftFacadeService.exchange(giftInfo);
    }
}
