package 桥接模式.复杂消息系统;

/**
 * 邮件消息的实现类
 *
 * @author: TangLiang
 * @date: 2021/2/18 16:08
 * @since: 1.0
 */
public class EmailMessage implements IMessage {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用邮件发送" + message + "给" + toUser);
    }
}
