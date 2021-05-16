package creation.abstractFactory;

import creation.abstractFactory.factory.CacheService;
import creation.abstractFactory.factory.JDKProxy;
import creation.abstractFactory.factory.impl.CacheServiceImpl;
import creation.abstractFactory.factory.impl.EGMCacheAdapter;
import creation.abstractFactory.factory.impl.IIRCacheAdapter;
import org.junit.Test;

//抽象工厂
public class ApiTest {

    //从结果上看运行正常，并没有什么问题。但这样的代码只要到生成运行起来以后，想再改就真的难了！
//    @Test
//    public void test_CacheService() {
//        CacheService cacheService = new CacheServiceImpl();
//        cacheService.set("user_name_01", "小华哥", 1);
//        String val01 = cacheService.get("user_name_01", 1);
//        System.out.println(val01);
//    }

    @Test
    public void test_CacheServiceTwo() throws Exception {
        CacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("user_name_01", "小华哥");
        String val01 = proxy_EGM.get("user_name_01");
        System.out.println(val01);

        CacheService proxy_IIR = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        proxy_IIR.set("user_name_01", "小华哥");
        String val02 = proxy_IIR.get("user_name_01");
        System.out.println(val02);
    }
    //总结：
    //抽象工厂模式，所要解决的问题就是在一个产品族，存在多个不同类型的产品(Redis集群、操作系统)情况下，接口选择的问题。而这种场景在业务开发中也是非常多见的，只不过可能有时候没有将它们抽象化出来。
    //你的代码只是被ifelse埋上了！当你知道什么场景下何时可以被抽象工程优化代码，那么你的代码层级结构以及满足业务需求上，都可以得到很好的完成功能实现并提升扩展性和优雅度。
    //那么这个设计模式满足了；单一职责、开闭原则、解耦等优点，但如果说随着业务的不断拓展，可能会造成类实现上的复杂度。
    //但也可以说算不上缺点，因为可以随着其他设计方式的引入和代理类以及自动生成加载的方式降低此项缺点

}
