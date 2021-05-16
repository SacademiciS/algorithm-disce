package behavioral.strategy;

import behavioral.strategy.event.MJCouponDiscount;
import behavioral.strategy.event.NYGCouponDiscount;
import behavioral.strategy.event.ZJCouponDiscount;
import behavioral.strategy.event.ZKCouponDiscount;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

//策略模式
public class ApiTest {

    @Test
    public void test_zj() {
        // 直减；100-10，商品100元
        Context<Double> context = new Context<Double>(new ZJCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(10D, new BigDecimal(100));
        System.out.println("测试结果：直减优惠后金额: " + discountAmount);
    }

    @Test
    public void test_mj() {
        // 满100减10，商品100元
        Context<Map<String, String>> context = new Context<Map<String, String>>(new MJCouponDiscount());
        Map<String, String> mapReq = new HashMap<String, String>();
        mapReq.put("x", "100");
        mapReq.put("n", "10");
        BigDecimal discountAmount = context.discountAmount(mapReq, new BigDecimal(100));
        System.out.println("测试结果：满减优惠后金额: " + discountAmount);
    }

    @Test
    public void test_zk() {
        // 折扣9折，商品100元
        Context<Double> context = new Context<>(new ZKCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(0.9D, new BigDecimal(100));
        System.out.println("测试结果：满减优惠后金额: " + discountAmount);
    }

    @Test
    public void test_nyg() {
        // n元购；100-10，商品100元
        Context<Double> context = new Context<>(new NYGCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(90D, new BigDecimal(100));
        System.out.println("测试结果：满减优惠后金额: " + discountAmount);
    }
    //总结：
    //以上的策略模式案例相对来说不并不复杂，主要的逻辑都是体现在关于不同种类优惠券的计算折扣策略上。结构相对来说也比较简单，在实际的开发中这样的设计模式也是非常常用的。另外这样的设计与命令模式、适配器模式结构相似，但是思路是有差异的。
    //通过策略设计模式的使用可以把我们方法中的if语句优化掉，大量的if语句使用会让代码难以扩展，也不好维护，同时在后期遇到各种问题也很难维护。在使用这样的设计模式后可以很好的满足隔离性与和扩展性，对于不断新增的需求也非常方便承接。
    //策略模式、适配器模式、组合模式等，在一些结构上是比较相似的，但是每一个模式是有自己的逻辑特点，在使用的过程中最佳的方式是经过较多的实践来吸取经验，为后续的研发设计提供更好的技术输出
}
