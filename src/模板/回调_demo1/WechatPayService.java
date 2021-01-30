package 模板.回调_demo1;

/**
 * @author: tangliang
 * @date: 2020/4/10 13:19.
 * @description: XXX
 */
public class WechatPayService {

    public void pay(long uid, long money, IPayCallback iPayCallback) {
        System.out.println("微信支付成功");
        iPayCallback.processPaySuccess(uid, money, true);
    }
}
