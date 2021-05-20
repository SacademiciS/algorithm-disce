package structure.adapter.design.impl;

import structure.adapter.design.OrderAdapterService;
import structure.adapter.service.OrderService;

public class InsideOrderService implements OrderAdapterService {

    private OrderService orderService = new OrderService();

    @Override
    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }
}
