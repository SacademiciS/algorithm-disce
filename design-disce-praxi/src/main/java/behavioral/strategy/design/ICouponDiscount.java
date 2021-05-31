package behavioral.strategy.design;

import java.math.BigDecimal;

//定义了优惠券折扣接口，也增加了泛型用于不同类型的接口可以传递不同的类型参数。
//接口中包括商品金额以及出参返回最终折扣后的金额，这里在实际开发中会比现在的接口参数多一些，但核心逻辑是这些。
public interface ICouponDiscount<T> {

    /**
     * 优惠券金额计算
     *
     * @param couponInfo 券折扣信息；直减、满减、折扣、N元购
     * @param skuPrice   sku金额
     * @return 优惠后金额
     */
    BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice);

}
