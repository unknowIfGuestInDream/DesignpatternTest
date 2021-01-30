package 适配器模式.exe1_封装外部接口;

import 适配器模式.Response;

/**
 * @author: tangliang
 * @date: 2020/3/31 21:47.
 * @description: 将OrderService返回值改为Response
 */
public interface LocalOrderServcie {

    Response createOrder(long userId, long orderId);

    Response refundOrder(long userId, long orderId);
}
