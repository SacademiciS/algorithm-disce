package behavioral.observer.design;

import behavioral.observer.service.MinibusTargetService;

import java.util.Date;

public class LotteryServiceImpl extends LotteryService {

    private MinibusTargetService minibusTargetService = new MinibusTargetService();

    //现在再看业务流程的实现中可以看到已经非常简单了，没有额外的辅助流程，只有核心流程的处理
    @Override
    protected LotteryResult doDraw(String uId) {
        String lottery = minibusTargetService.lottery(uId);
        return new LotteryResult(uId, lottery, new Date());
    }
}
