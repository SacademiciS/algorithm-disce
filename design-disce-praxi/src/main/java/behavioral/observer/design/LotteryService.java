package behavioral.observer.design;

import behavioral.observer.design.event.EventManager;
import behavioral.observer.design.event.listener.MQEventListener;
import behavioral.observer.design.event.listener.MessageEventListener;

/**
 * 具体的业务流程
 */
public abstract class LotteryService {

    private EventManager eventManager;

    public LotteryService() {
        eventManager = new EventManager(EventManager.EventType.MQ, EventManager.EventType.Message);
        eventManager.subscribe(EventManager.EventType.MQ, new MQEventListener());
        eventManager.subscribe(EventManager.EventType.Message, new MessageEventListener());
    }

    public LotteryResult draw(String uId) {
        LotteryResult lotteryResult = doDraw(uId);
        // 需要什么通知就给调用什么方法
        eventManager.notify(EventManager.EventType.MQ, lotteryResult);
        eventManager.notify(EventManager.EventType.Message, lotteryResult);
        return lotteryResult;
    }
    //这种使用抽象类的方式定义实现方法，可以在方法中扩展需要的额外调用。并提供抽象类abstract LotteryResult doDraw(String uId)，让类的继承者实现。
    //同时方法的定义使用的是protected，也就是保证将来外部的调用方不会调用到此方法，只有调用到draw(String uId)，才能让我们完成事件通知
    protected abstract LotteryResult doDraw(String uId);

    //此种方式的实现就是在抽象类中写好一个基本的方法，在方法中完成新增逻辑的同时，再增加抽象类的使用。而这个抽象类的定义会有继承者实现。
    //另外在构造函数中提供了对事件的定义；eventManager.subscribe(EventManager.EventType.MQ, new MQEventListener())。
    //在使用的时候也是使用枚举的方式进行通知使用，传了什么类型EventManager.EventType.MQ，就会执行什么事件通知，按需添加。
}
