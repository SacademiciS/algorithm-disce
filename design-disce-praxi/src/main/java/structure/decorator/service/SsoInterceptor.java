package structure.decorator.service;

import structure.decorator.service.HandlerInterceptor;

//具体构件角色(ConcreteComponent)
public class SsoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(String request, String response, Object handler) {
        //模拟获取cookie
        String ticket = request.substring(1, 8);
        //模拟校验
        return ticket.equals("success");
    }
}
