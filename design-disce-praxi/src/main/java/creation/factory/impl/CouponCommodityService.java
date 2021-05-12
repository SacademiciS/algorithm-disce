package creation.factory.impl;

import com.alibaba.fastjson.JSON;
import creation.factory.ICommodity;

import java.util.Map;

public class CouponCommodityService implements ICommodity {

    //private Logger logger = LoggerFactory.getLogger(CouponCommodityService.class);

    //private CouponService couponService = new CouponService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        //CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        //logger.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        //logger.info("测试结果[优惠券]：{}", JSON.toJSON(couponResult));
        //if (!"0000".equals(couponResult.getCode())) throw new RuntimeException(couponResult.getInfo());
        System.out.println(String.format("请求参数[优惠券] => uId：%s commodityId：%s bizId：%s extMap：%s", uId, commodityId, bizId, JSON.toJSON(extMap)));
    }
}
