package behavioral.observer.design.event.listener;

import behavioral.observer.design.LotteryResult;

/**
 * 事件监听接口
 */
public interface EventListener {

    void doEvent(LotteryResult result);
}
