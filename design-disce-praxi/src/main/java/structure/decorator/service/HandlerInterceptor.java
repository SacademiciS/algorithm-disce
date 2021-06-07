package structure.decorator.service;

//抽象构件角色(Component)
public interface HandlerInterceptor {

    boolean preHandle(String request, String response, Object handler);

}
