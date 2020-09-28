package 享元.火车票;

/**
 * @author: TangLiang
 * @date: 2020/9/27 14:39
 * @since: 1.0
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i <3 ; i++) {
            ITicket ticket = TicketFactory.queryTicket("大连北", "大连");
            ticket.showInfo("硬座");
        }

    }
}
