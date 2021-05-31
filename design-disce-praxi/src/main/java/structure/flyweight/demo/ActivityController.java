package structure.flyweight.demo;

import structure.flyweight.model.Activity;
import structure.flyweight.model.Stock;

import java.util.Date;

/**
 * @Author: wjh
 * @Description
 * @Date: 2021/5/31 15:57
 */
public class ActivityController {

    public Activity queryActivityInfo(Long id) {
        // 模拟从实际业务应用从接口中获取活动信息
        Activity activity = new Activity();
        activity.setId(10001L);
        activity.setName("图书嗨乐");
        activity.setDesc("图书优惠券分享激励分享活动第二期");
        activity.setStartTime(new Date());
        activity.setStopTime(new Date());
        activity.setStock(new Stock(1000, 1));
        return activity;
    }
}
