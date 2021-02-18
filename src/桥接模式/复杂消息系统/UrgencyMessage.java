package 桥接模式.复杂消息系统;

/**
 * 加急消息类
 *
 * @author: TangLiang
 * @date: 2021/2/18 16:14
 * @since: 1.0
 */
public class UrgencyMessage extends AbstractMessage {
    public UrgencyMessage(IMessage message) {
        super(message);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        message = "加急" + message;
        super.sendMessage(message, toUser);
    }

    //扩展功能，监控某个消息的处理状态
    public Object watch(String messageId) {
        //根据给出的消息编码 messageId 查询消息的处理状态
        //组织成监控的处理状态，然后返回
        return null;
    }
}
