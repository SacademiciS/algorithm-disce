package behavioral.strategy.event;

import behavioral.strategy.ICouponDiscount;

import java.math.BigDecimal;
import java.util.Map;

public class MJCouponDiscount implements ICouponDiscount<Map<String, String>> {
    /**
     * 满减计算
     * 1. 判断满足x元后-n元，否则不减
     * 2. 最低支付金额1元
     */
    @Override
    public BigDecimal discountAmount(Map<String, String> couponInfo, BigDecimal skuPrice) {
        String x = couponInfo.get("x");
        String o = couponInfo.get("n");

        if (skuPrice.compareTo(new BigDecimal(x)) < 0) return skuPrice;

        BigDecimal discountAmout = skuPrice.subtract(new BigDecimal(o));
        if (discountAmout.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
        return discountAmout;
    }
}
