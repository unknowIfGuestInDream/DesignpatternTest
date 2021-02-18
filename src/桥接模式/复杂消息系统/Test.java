package 桥接模式.复杂消息系统;

/**
 * @author: TangLiang
 * @date: 2021/2/18 16:16
 * @since: 1.0
 */
public class Test {
    public static void main(String[] args) {
        IMessage message = new SmsMessage();
        AbstractMessage abstractMessage = new NomalMessage(message);
        abstractMessage.sendMessage("加班申请速批", "王总");

        message = new EmailMessage();
        abstractMessage = new UrgencyMessage(message);
        abstractMessage.sendMessage("加班申请速批", "王总");
    }
}
