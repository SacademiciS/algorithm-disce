package behavioral.command.demo;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class XiaoEr {

    private Logger logger = LoggerFactory.getLogger(XiaoEr.class);

    private Map<Integer, String> cuisineMap = new ConcurrentHashMap<Integer, String>();
    //在这个类的实现中提供了两个方法，一个方法用于点单添加菜品order()，另外一个方法展示菜品的信息placeOrder()。
    //从上面可以看到有比较多的if语句判断类型进行添加菜品，那么对于这样的代码后续就需要大量的经历进行维护，同时可能实际的逻辑要比这复杂的多。都写在这样一个类里会变得耦合的非常严重。
    public void order(int cuisine) {
        //广东
        if (1 == cuisine) {
            cuisineMap.put(1, "广东厨师，烹饪鲁菜，宫廷最大菜系，以孔府风味为龙头");
        }
        //江苏
        if (2 == cuisine) {
            cuisineMap.put(2, "江苏厨师，烹饪苏菜，宫廷第二大菜系，古今国宴上最受人欢迎的菜系。");
        }
        //山东
        if (3 == cuisine) {
            cuisineMap.put(3, "山东厨师，烹饪鲁菜，宫廷最大菜系，以孔府风味为龙头.");
        }
        //四川
        if (4 == cuisine) {
            cuisineMap.put(4, "四川厨师，烹饪川菜，中国最有特色的菜系，也是民间最大菜系。");
        }
    }

    public void placeOrder() {
        logger.info("菜单：{}", JSON.toJSONString(cuisineMap));
    }
}
