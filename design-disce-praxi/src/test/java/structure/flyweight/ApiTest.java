package structure.flyweight;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import structure.flyweight.design.ActivityController;
import structure.flyweight.model.Activity;

/**
 * @Author: wjh
 * @Description 享元模式
 * @Date: 2021/5/31 16:55
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    private ActivityController activityController = new ActivityController();

    //这里我们通过活动查询控制类，在for循环的操作下查询了十次活动信息，同时为了保证库存定时任务的变化，加了睡眠操作，实际的开发中不会有这样的睡眠。
    //可以仔细看下stock部分的库存是一直在变化的，其他部分是活动信息，是固定的，所以我们使用享元模式来将这样的结构进行拆分。
    @Test
    public void test_queryActivityInfo() throws InterruptedException {
        for (int idx = 0; idx < 10; idx++) {
            Long req = 10001L;
            Activity activity = activityController.queryActivityInfo(req);
            logger.info("测试结果：{} {}", req, JSON.toJSONString(activity));
            Thread.sleep(1200);
        }
    }
    //总结：
    //关于享元模式的设计可以着重学习享元工厂的设计，在一些有大量重复对象可复用的场景下，使用此场景在服务端减少接口的调用，在客户端减少内存的占用。是这个设计模式的主要应用方式。
    //另外通过map结构的使用方式也可以看到，使用一个固定id来存放和获取对象，是非常关键的点。而且不只是在享元模式中使用，一些其他工厂模式、适配器模式、组合模式中都可以通过map结构存放服务供外部获取，减少ifelse的判断使用。
    //当然除了这种设计的减少内存的使用优点外，也有它带来的缺点，在一些复杂的业务处理场景，很不容易区分出内部和外部状态，就像我们活动信息部分与库存变化部分。如果不能很好的拆分，就会把享元工厂设计的非常混乱，难以维护。
}
