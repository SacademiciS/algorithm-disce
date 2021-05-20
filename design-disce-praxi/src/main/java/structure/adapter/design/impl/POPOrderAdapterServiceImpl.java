package structure.adapter.design.impl;

import structure.adapter.design.OrderAdapterService;
import structure.adapter.service.POPOrderService;

public class POPOrderAdapterServiceImpl implements OrderAdapterService {

    private POPOrderService popOrderService = new POPOrderService();

    @Override
    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }
}
