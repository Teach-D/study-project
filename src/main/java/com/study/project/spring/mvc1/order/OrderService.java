package sw.contest.spring.mvc1.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int price);

}
