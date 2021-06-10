package behavioral.stencil;

import behavioral.stencil.design.NetMall;
import behavioral.stencil.design.group.JDNetMall;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//模版模式
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 测试链接
     * 京东；https://item.jd.com/100008348542.html
     * 淘宝；https://detail.tmall.com/item.htm
     * 当当；http://product.dangdang.com/1509704171.html
     */
    @Test
    public void test_NetMall() {
        NetMall netMall = new JDNetMall("1000001","*******");
        String base64 = netMall.generateGoodsPoster("https://item.jd.com/100008348542.html");
        logger.info("测试结果：{}", base64);
    }
    //总结：
    //通过上面的实现可以看到模版模式在定义统一结构也就是执行标准上非常方便，也就很好的控制了后续的实现者不用关心调用逻辑，按照统一方式执行。那么类的继承者只需要关心具体的业务逻辑实现即可。
    //另外模版模式也是为了解决子类通用方法，放到父类中设计的优化。让每一个子类只做子类需要完成的内容，而不需要关心其他逻辑。这样提取公用代码，行为由父类管理，扩展可变部分，也就非常有利于开发拓展和迭代。
    //但每一种设计模式都有自己的特定场景，如果超过场景外的建设就需要额外考虑🤔其他模式的运用。而不是非要生搬硬套，否则自己不清楚为什么这么做，也很难让后续者继续维护代码。而想要活学活用就需要多加练习，有实践的经历。
}
