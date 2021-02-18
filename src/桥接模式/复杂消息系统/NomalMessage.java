package 桥接模式.复杂消息系统;

/**
 * 普通消息类
 *
 * @author: TangLiang
 * @date: 2021/2/18 16:13
 * @since: 1.0
 */
public class NomalMessage extends AbstractMessage {

    public NomalMessage(IMessage message) {
        super(message);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        //对于普通消息，直接调用父类方法即可
        super.sendMessage(message, toUser);
    }
}
