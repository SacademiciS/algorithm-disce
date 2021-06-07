package structure.decorator.design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import structure.decorator.service.HandlerInterceptor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//具体装饰角色(ConcreteDecorator)
public class LoginSsoDecorator extends SsoDecorator {
    //在具体的装饰类实现中，继承了装饰类SsoDecorator，那么现在就可以扩展方法；preHandle
    //在preHandle的实现中可以看到，这里只关心扩展部分的功能，同时不会影响原有类的核心服务，也不会因为使用继承方式而导致的多余子类，增加了整体的灵活性。

    private Logger logger = LoggerFactory.getLogger(LoginSsoDecorator.class);

    private static Map<String, String> authMap = new ConcurrentHashMap<String, String>();

    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }

    public LoginSsoDecorator(HandlerInterceptor handlerInterceptor) {
        super(handlerInterceptor);
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        boolean success = super.preHandle(request, response, handler);
        if (!success) return false;
        String userId = request.substring(8);
        String method = authMap.get(userId);
        logger.info("模拟单点登录方法访问拦截校验：{} {}", userId, method);
        // 模拟方法校验
        return "queryUserInfo".equals(method);
    }
}
