package structure.status;

import behavioral.status.demo.ActivityExecStatusController;
import behavioral.status.demo.Result;
import behavioral.status.design.StateHandler;
import behavioral.status.service.ActivityService;
import behavioral.status.service.Status;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//状态模式
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test() {
        //初始化数据
        String activityId = "100001";
        ActivityService.init(activityId, Status.Editing);

        ActivityExecStatusController activityExecStatusController = new ActivityExecStatusController();
        Result result = activityExecStatusController.execStatus(activityId, Status.Editing, Status.Refuse);
        logger.info("测试结果(编辑中To审核拒绝)：{}", JSON.toJSONString(result));

        Result resultCheck = activityExecStatusController.execStatus(activityId, Status.Editing, Status.Check);
        logger.info("测试结果(编辑中To提交审核)：{}", JSON.toJSONString(resultCheck));
    }

    //测试编辑中To提审活动，的状态流转
    @Test
    public void test_Editing2Arraignment() {
        String activityId = "100001";
        ActivityService.init(activityId, Status.Editing);

        StateHandler stateHandler = new StateHandler();
        behavioral.status.design.Result result = stateHandler.arraignment(activityId, Status.Editing);

        logger.info("测试结果(编辑中To提审活动)：{}", JSON.toJSONString(result));
        logger.info("活动信息：{} 状态：{}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)), JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
    }

    //测试编辑中To开启活动，的状态流转
    @Test
    public void test_Editing2Open() {
        String activityId = "100001";
        ActivityService.init(activityId, Status.Editing);

        StateHandler stateHandler = new StateHandler();
        behavioral.status.design.Result result = stateHandler.open(activityId, Status.Editing);

        logger.info("测试结果(编辑中To开启活动)：{}", JSON.toJSONString(result));
        logger.info("活动信息：{} 状态：{}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)), JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
    }

    //测试拒绝To活动中，的状态流转
    @Test
    public void test_Refuse2Doing() {
        String activityId = "100001";
        ActivityService.init(activityId, Status.Refuse);

        StateHandler stateHandler = new StateHandler();
        behavioral.status.design.Result result = stateHandler.doing(activityId, Status.Refuse);

        logger.info("测试结果(拒绝To活动中)：{}", JSON.toJSONString(result));
        logger.info("活动信息：{} 状态：{}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)), JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
    }
    //总结：
    //从以上的两种方式对一个需求的实现中可以看到，在第二种使用设计模式处理后已经没有了ifelse，代码的结构也更加清晰易于扩展。这就是设计模式的好处，可以非常强大的改变原有代码的结构，让以后的扩展和维护都变得容易些。
    //在实现结构的编码方式上可以看到这不再是面向过程的编程，而是面向对象的结构。并且这样的设计模式满足了单一职责和开闭原则，当你只有满足这样的结构下才会发现代码的扩展是容易的，也就是增加和修改功能不会影响整体的变化。
    //但如果状态和各项流转较多像本文的案例中，就会产生较多的实现类。因此可能也会让代码的实现上带来了时间成本，因为如果遇到这样的场景可以按需评估投入回报率。主要点在于看是否经常修改、是否可以做成组件化、抽离业务与非业务功能。

}
