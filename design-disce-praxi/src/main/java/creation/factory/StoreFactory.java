package creation.factory;

import creation.factory.impl.CardCommodityService;
import creation.factory.impl.CouponCommodityService;
import creation.factory.impl.GoodsCommodityService;

public class StoreFactory {

    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        switch (commodityType) {
            case 1:
                return new CouponCommodityService();
            case 2:
                return new GoodsCommodityService();
            case 3:
                return new CardCommodityService();
            default:
                throw new RuntimeException("不存在的商品服务类型");
        }
    }

}
