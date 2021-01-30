package 桥接模式.v3;

import 桥接模式.v3.handler.MsgHandler;

/**
 * @author: tangliang
 * @date: 2020/3/29 23:10.
 * @description: XXX
 */
public class KafkaMsgProcessor extends MqMsgProcessor {

    public KafkaMsgProcessor(MsgHandler msgHandler) {
        super(msgHandler);
    }

    @Override
    public void processMqMsg(String topic, String message) {
        msgHandler.processMsg(message);
    }
}
