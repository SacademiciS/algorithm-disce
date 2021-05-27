package structure.combination.design.service.engine;

import structure.combination.design.service.logic.LogicFilter;
import structure.combination.design.service.logic.impl.UserAgeFilter;
import structure.combination.design.service.logic.impl.UserGenderFilter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: wjh
 * @Description
 * @Date: 2021/5/27 11:30
 */
public class EngineConfig {

    static Map<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap = new ConcurrentHashMap<>();
        logicFilterMap.put("userAge", new UserAgeFilter());
        logicFilterMap.put("userGender", new UserGenderFilter());
    }

    public static Map<String, LogicFilter> getLogicFilterMap() {
        return logicFilterMap;
    }

    public static void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
        EngineConfig.logicFilterMap = logicFilterMap;
    }
}
