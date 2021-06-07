package structure.decorator;

import org.junit.Test;
import structure.decorator.design.LoginSsoDecorator;
import structure.decorator.service.SsoInterceptor;

public class ApiTest {

//    @Test
//    public void test_LoginSsoDecorator() {
//        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator();
//        String request = "1successhuahua";
//        boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
//        System.out.println("登录校验：" + request + (success ? " 放行" : " 拦截"));
//    }

    @Test
    public void test_LoginSsoDecorator() {
        //这里测试了对装饰器模式的使用，通过透传原有单点登录类new SsoInterceptor()，传递给装饰器，让装饰器可以执行扩充的功能。
        //同时对于传递者和装饰器都可以是多组的，在一些实际的业务开发中，往往也是由于太多类型的子类实现而导致不易于维护，从而使用装饰器模式替代。
        //备注：传递者为 SsoInterceptor;装饰器为 LoginSsoDecorator
        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator(new SsoInterceptor());
        String request = "1successhuahua";
        boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
        System.out.println("登录校验：" + request + (success ? " 放行" : " 拦截"));
    }
    //总结：
    //使用装饰器模式满足单一职责原则，你可以在自己的装饰类中完成功能逻辑的扩展，而不影响主类，同时可以按需在运行时添加和删除这部分逻辑。另外装饰器模式与继承父类重写方法，在某些时候需要按需选择，并不一定某一个就是最好。
    //装饰器实现的重点是对抽象类继承接口方式的使用，同时设定被继承的接口可以通过构造函数传递其实现类，由此增加扩展性并重写方法里可以实现此部分父类实现的功能。
    //就像夏天热你穿短裤，冬天冷你穿棉裤，雨天挨浇你穿雨衣一样，你的根本本身没有被改变，而你的需求却被不同的装饰而实现。生活中往往比比皆是设计，当你可以融合这部分活灵活现的例子到代码实现中，往往会创造出更加优雅的实现方式
}
