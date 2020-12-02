package 享元.火车票;

import util.CacheUtil;

import static util.CacheUtil.CACHE_HOLD_TIME_1S;

/**
 * @author: TangLiang
 * @date: 2020/9/27 14:38
 * @since: 1.0
 */
public class TicketFactory {
//    private static Map<String, ITicket> sTicketPool = new ConcurrentHashMap<>();
//
//    public static ITicket queryTicket(String from, String to) {
//        String key = from + "->" + to;
//        if (TicketFactory.sTicketPool.containsKey(key)) {
//            System.out.println("使用缓存: " + key);
//            return TicketFactory.sTicketPool.get(key);
//        }
//        System.out.println("首次查询,创建对象: " + key);
//        ITicket iTicket = new TrainTicket(from, to);
//        TicketFactory.sTicketPool.put(key, iTicket);
//        return iTicket;
//    }

    //带时间的缓存
    public static ITicket queryTicket(String from, String to) {
        String key = from + "->" + to;
        if (CacheUtil.get(key) != null) {
            System.out.println("使用缓存: " + key);
            return (ITicket) CacheUtil.get(key);
        }
        System.out.println("首次查询,创建对象: " + key);
        ITicket iTicket = new TrainTicket(from, to);
        CacheUtil.put(key, iTicket, CACHE_HOLD_TIME_1S);
        return iTicket;
    }


}
