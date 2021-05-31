package structure.flyweight.design;

import structure.flyweight.design.util.RedisUtils;
import structure.flyweight.model.Activity;
import structure.flyweight.model.Stock;

/**
 * @Author: wjh
 * @Description
 * @Date: 2021/5/31 16:53
 */
public class ActivityController {

    private RedisUtils redisUtils = new RedisUtils();

    public Activity queryActivityInfo(Long id) {
        Activity activity = ActivityFactory.getActivity(id);
        // 模拟从Redis中获取库存变化信息
        Stock stock = new Stock(1000, redisUtils.getStockUsed());
        activity.setStock(stock);
        return activity;
    }

}
