package 桥接模式.复杂消息系统;

/**
 * 短信消息实现类
 *
 * @author: TangLiang
 * @date: 2021/2/18 16:09
 * @since: 1.0
 */
public class SmsMessage implements IMessage {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用短信发送" + message + "给" + toUser);
    }
}
