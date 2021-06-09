package behavioral.observer;

import behavioral.observer.design.LotteryResult;
import behavioral.observer.design.LotteryService;
import behavioral.observer.design.LotteryServiceImpl;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//观察者模式
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Test
//    public void test() {
//        LotteryService lotteryService = new LotteryServiceImpl();
//        LotteryResult result = lotteryService.doDraw("2765789109876");
//        logger.info("测试结果：{}", JSON.toJSONString(result));
//    }

    @Test
    public void test() {
        LotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult result = lotteryService.draw("2765789109876");
        logger.info("测试结果：{}", JSON.toJSONString(result));
    }
    //总结：
    //从我们最基本的过程式开发以及后来使用观察者模式面向对象开发，可以看到设计模式改造后，拆分出了核心流程与辅助流程的代码。一般代码中的核心流程不会经常变化。但辅助流程会随着业务的各种变化而变化，包括；营销、裂变、促活等等，因此使用设计模式架设代码就显得非常有必要。
    //此种设计模式从结构上是满足开闭原则的，当你需要新增其他的监听事件或者修改监听逻辑，是不需要改动事件处理类的。但是可能你不能控制调用顺序以及需要做一些事件结果的返回继续操作，所以使用的过程时需要考虑场景的合理性。
    //任何一种设计模式有时候都不是单独使用的，需要结合其他模式共同建设。另外设计模式的使用是为了让代码更加易于扩展和维护，不能因为添加设计模式而把结构处理更加复杂以及难以维护。这样的合理使用的经验需要大量的实际操作练习而来。
}
