package structure.combination.design.service.logic.impl;

import structure.combination.design.service.logic.BaseLogic;

import java.util.Map;

/**
 * @Author: wjh
 * @Description
 * @Date: 2021/5/27 11:00
 */
public class UserAgeFilter extends BaseLogic {
    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("age");
    }
}
