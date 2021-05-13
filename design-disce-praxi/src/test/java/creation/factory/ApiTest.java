package creation.factory;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//工厂模式
public class ApiTest {

    @Test
    public void test_commodity() throws Exception {
        StoreFactory storeFactory = new StoreFactory();
        // 1. 优惠券
        ICommodity commodityService_1 = storeFactory.getCommodityService(1);
        commodityService_1.sendCommodity("10001", "EGM1023938910232121323432", "791098764902132", null);
        // 2. 实物商品
        ICommodity commodityService_2 = storeFactory.getCommodityService(2);

        Map<String, String> extMap = new HashMap<String, String>();
        extMap.put("consigneeUserName", "谢飞机");
        extMap.put("consigneeUserPhone", "15200292123");
        extMap.put("consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109");

        commodityService_2.sendCommodity("10001", "9820198721311", "1023000020112221113", extMap);
        // 3. 第三方兑换卡(爱奇艺)
        ICommodity commodityService_3 = storeFactory.getCommodityService(3);
        commodityService_3.sendCommodity("10001", "AQY1xjkUodl8LO975GdfrYUio", null, null);
    }
    //总结:
    //从上到下的优化来看，工厂方法模式并不复杂，甚至这样的开发结构在你有所理解后，会发现更加简单了。
    //那么这样的开发的好处知道后，也可以总结出来它的优点；避免创建者与具体的产品逻辑耦合、满足单一职责，
    //每一个业务逻辑实现都在所属自己的类中完成、满足开闭原则，无需更改使用调用方就可以在程序中引入新的产品类型。
    //但这样也会带来一些问题，比如有非常多的奖品类型，那么实现的子类会极速扩张。因此也需要使用其他的模式进行优化，这些在后续的设计模式中会逐步涉及到。
    //从案例入手看设计模式往往要比看理论学的更加容易，因为案例是缩短理论到上手的最佳方式，如果你已经有所收获，一定要去尝试实操。
}
