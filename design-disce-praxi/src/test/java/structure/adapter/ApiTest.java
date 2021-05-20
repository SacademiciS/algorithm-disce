package structure.adapter;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import structure.adapter.design.MQAdapter;
import structure.adapter.design.OrderAdapterService;
import structure.adapter.design.RebateInfo;
import structure.adapter.design.impl.InsideOrderService;
import structure.adapter.design.impl.POPOrderAdapterServiceImpl;
import structure.adapter.mq.OrderMq;
import structure.adapter.mq.create_account;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;

//适配器模式
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test_MQAdapter() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        create_account create_account = new create_account();
        create_account.setNumber("100001");
        create_account.setAddress("河北省.廊坊市.广阳区.大学里职业技术学院");
        create_account.setAccountDate(new Date());
        create_account.setDesc("在校开户");

        HashMap<String, String> link01 = new HashMap<String, String>();
        link01.put("userId", "number");
        link01.put("bizId", "number");
        link01.put("bizTime", "accountDate");
        link01.put("desc", "desc");
        RebateInfo rebateInfo01 = MQAdapter.filter(create_account.toString(), link01);
        System.out.println("mq.create_account(适配前)" + create_account.toString());
        System.out.println("mq.create_account(适配后)" + JSON.toJSONString(rebateInfo01));

        OrderMq orderMq = new OrderMq();
        orderMq.setUid("100001");
        orderMq.setSku("10928092093111123");
        orderMq.setOrderId("100000890193847111");
        orderMq.setCreateOrderTime(new Date());

        HashMap<String, String> link02 = new HashMap<String, String>();
        link02.put("userId", "uid");
        link02.put("bizId", "orderId");
        link02.put("bizTime", "createOrderTime");
        RebateInfo rebateInfo02 = MQAdapter.filter(orderMq.toString(), link02);

        System.out.println("mq.create_account(适配前)" + orderMq.toString());
        System.out.println("mq.create_account(适配后)" + JSON.toJSONString(rebateInfo02));
    }

    @Test
    public void test_itfAdapter() {
        OrderAdapterService popOrderAdapterService = new POPOrderAdapterServiceImpl();
        System.out.println("判断首单，接口适配(POP)：" + popOrderAdapterService.isFirst("100001"));

        OrderAdapterService insideOrderService = new InsideOrderService();
        System.out.println("判断首单，接口适配(自营)：" + insideOrderService.isFirst("100001"));
    }
    //总结：
    //从上文可以看到不使用适配器模式这些功能同样可以实现，但是使用了适配器模式就可以让代码：干净整洁易于维护、减少大量重复的判断和使用、让代码更加易于维护和拓展。
    //尤其是我们对MQ这样的多种消息体中不同属性同类的值，进行适配再加上代理类，就可以使用简单的配置方式接入对方提供的MQ消息，而不需要大量重复的开发。非常利于拓展。
    //设计模式的学习学习过程可能会在一些章节中涉及到其他设计模式的体现，只不过不会重点讲解，避免喧宾夺主。但在实际的使用中，往往很多设计模式是综合使用的，并不会单一出现。

}
