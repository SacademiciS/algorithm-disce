package creation.factory.impl;

import com.alibaba.fastjson.JSON;
import creation.factory.ICommodity;

import java.util.Map;

public class GoodsCommodityService implements ICommodity {
    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        System.out.println(String.format("请求参数[爱奇艺兑换卡] => uId：%s commodityId：%s bizId：%s extMap：%s", uId, commodityId, bizId, JSON.toJSON(extMap)));
        System.out.println("测试结果[爱奇艺兑换卡]：success");
    }
}
