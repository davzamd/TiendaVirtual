package base.order.persistance;

import base.order.domain.Order;

public interface OrderDAO {
    boolean UpdateOrder(Order order);
}
