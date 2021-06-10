package behavioral.medium;

import behavioral.medium.design.mediator.Resources;
import behavioral.medium.design.mediator.SqlSession;
import behavioral.medium.design.mediator.SqlSessionFactory;
import behavioral.medium.design.mediator.SqlSessionFactoryBuilder;
import behavioral.medium.design.po.User;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Reader;

//中介者模式
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_queryUserInfoById() {
        String resource = "mybatis-config-datasource.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlMapper.openSession();
            try {
                User user = session.selectOne("behavioral.medium.design.dao.IUserDao.queryUserInfoById", 1L);
                logger.info("测试结果：{}", JSON.toJSONString(user));
            } finally {
                session.close();
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //总结：
    //以上通过中介者模式的设计思想我们手写了一个ORM框架，隐去了对数据库操作的复杂度，让外部的调用方可以非常简单的进行操作数据库。这也是我们平常使用的Mybatis的原型，在我们日常的开发使用中，只需要按照配置即可非常简单的操作数据库。
    //除了以上这种组件模式的开发外，还有服务接口的包装也可以使用中介者模式来实现。比如你们公司有很多的奖品接口需要在营销活动中对接，那么可以把这些奖品接口统一收到中台开发一个奖品中心，对外提供服务。这样就不需要每一个需要对接奖品的接口，都去找具体的提供者，而是找中台服务即可。
    //在上述的实现和测试使用中可以看到，这种模式的设计满足了；单一职责和开闭原则，也就符合了迪米特原则，即越少人知道越好。外部的人只需要按照需求进行调用，不需要知道具体的是如何实现的，复杂的一面已经有组件合作服务平台处理.

}
