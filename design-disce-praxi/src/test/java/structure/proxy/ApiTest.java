package structure.proxy;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import structure.proxy.design.IUserDao;

//代理模式
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test_IUserDao() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserDao userDao = beanFactory.getBean("userDao", IUserDao.class);
        String res = userDao.queryUserInfo("100001");
        logger.info("测试结果：{}", res);
    }
    //从测试结果可以看到，我们打印了SQL语句，这部分语句是从自定义注解中获取的；select userName from user where id = 100001，我们做了简单的适配。在mybatis框架中会交给SqlSession的实现类进行逻辑处理返回操作数据库数据

    //总结：
    //关于这部分代理模式的讲解我们采用了开发一个关于mybatis-spring中间件中部分核心功能来体现代理模式的强大之处，所以涉及到了一些关于代理类的创建以及spring中bean的注册这些知识点，可能在平常的业务开发中都是很少用到的，但是在中间件开发中确实非常常见的操作。
    //代理模式除了开发中间件外还可以是对服务的包装，物联网组件等等，让复杂的各项服务变为轻量级调用、缓存使用。你可以理解为你家里的电灯开关，我们不能操作220v电线的人肉连接，但是可以使用开关，避免触电。
    //代理模式的设计方式可以让代码更加整洁、干净易于维护，虽然在这部分开发中额外增加了很多类也包括了自己处理bean的注册等，但是这样的中间件复用性极高也更加智能，可以非常方便的扩展到各个服务应用中。
}
