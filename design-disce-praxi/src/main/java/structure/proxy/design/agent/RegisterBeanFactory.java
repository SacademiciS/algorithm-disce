package structure.proxy.design.agent;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import structure.proxy.design.IUserDao;

public class RegisterBeanFactory implements BeanDefinitionRegistryPostProcessor {

    //这里我们将代理的bean交给spring容器管理，也就可以非常方便让我们可以获取到代理的bean。这部分是spring中关于一个bean注册过程的源码。
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(MapperFactoryBean.class);
        beanDefinition.setScope("singleton");
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(IUserDao.class);

        BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(beanDefinition, "userDao");
        BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, registry);
    }
    //GenericBeanDefinition，用于定义一个bean的基本信息setBeanClass(MapperFactoryBean.class);，也包括可以透传给构造函数信息addGenericArgumentValue(IUserDao.class);
    //最后使用 BeanDefinitionReaderUtils.registerBeanDefinition，进行bean的注册，也就是注册到DefaultListableBeanFactory中。

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // left intentionally blank
    }
}
