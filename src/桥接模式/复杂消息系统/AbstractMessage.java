package 桥接模式.复杂消息系统;

/**
 * 抽象消息类
 *
 * @author: TangLiang
 * @date: 2021/2/18 16:10
 * @since: 1.0
 */
public abstract class AbstractMessage {
    //持有一个实现部分的对象
    IMessage message;

    //构造方法，传入实现部分的对象
    public AbstractMessage(IMessage message) {
        this.message = message;
    }

    //发送消息，委派给实现部分的方法
    public void sendMessage(String message, String toUser) {
        this.message.send(message, toUser);
    }

}
