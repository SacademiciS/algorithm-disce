package structure.proxy.design.agent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

//如果你有阅读过mybatis源码，是可以看到这样的一个类；MapperFactoryBean，这里我们也模拟一个这样的类，在里面实现我们对代理类的定义。
public class MapperFactoryBean<T> implements FactoryBean<T> {
    //通过继承FactoryBean，提供bean对象，也就是方法；T getObject()。
    //在方法getObject()中提供类的代理以及模拟对sql语句的处理，这里包含了用户调用dao层方法时候的处理逻辑。
    //还有最上面我们提供构造函数来透传需要被代理类，Class<T> mapperInterface，在mybatis中也是使用这样的方式进行透传。
    //另外getObjectType()提供对象类型反馈，以及isSingleton()返回类是单例的。

    private Logger logger = LoggerFactory.getLogger(MapperFactoryBean.class);

    private Class<T> mapperInterface;

    public MapperFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() throws Exception {
        InvocationHandler handler = (proxy, method, args) -> {
            Select select = method.getAnnotation(Select.class);
            logger.info("SQL：{}", select.value().replace("#{uId}", args[0].toString()));
            return args[0] + ",小傅哥,bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！";
        };
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{mapperInterface}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
