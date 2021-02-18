package 桥接模式.复杂消息系统;

/**
 * 实现消息发送的统一接口
 *
 * @author: TangLiang
 * @date: 2021/2/18 16:07
 * @since: 1.0
 */
public interface IMessage {
    void send(String message, String toUser);
}
