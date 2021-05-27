package behavioral.strategy.demo;

/**
 * 优惠券折扣计算接口
 * <p>
 * 优惠券类型；
 * 1. 直减券
 * 2. 满减券
 * 3. 折扣券
 * 4. n元购
 */
public class CouponDiscountService {

    public double discountAmount(int type, double typeContent, double skuPrice, double typeExt) {
        // 1. 直减券
        if (1 == type) {
            return skuPrice - typeContent;
        }
        // 2. 满减券
        if (2 == type) {
            if (skuPrice < typeExt) return skuPrice;
            return skuPrice - typeContent;
        }
        // 3. 折扣券
        if (3 == type) {
            return skuPrice * typeContent;
        }
        // 4. n元购
        if (4 == type) {
            return typeContent;
        }
        return 0D;
    }
    //以上是不同类型的优惠券计算折扣后的实际金额。
    //入参包括；优惠券类型、优惠券金额、商品金额，因为有些优惠券是满多少减少多少，所以增加了typeExt类型。这也是方法的不好扩展性问题。
    //最后是整个的方法体中对优惠券抵扣金额的实现，最开始可能是一个最简单的优惠券，后面随着产品功能的增加，不断的扩展if语句。实际的代码可能要比这个多很多。
}