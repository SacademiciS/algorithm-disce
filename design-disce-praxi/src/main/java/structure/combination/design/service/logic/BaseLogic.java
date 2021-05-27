package structure.combination.design.service.logic;

import structure.combination.design.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 * @Author: wjh
 * @Description
 * @Date: 2021/5/27 10:59
 */
public abstract class BaseLogic implements LogicFilter {
    @Override
    public Long filter(String matterValue, List<TreeNodeLink> treeNodeLineInfoList) {
        for (TreeNodeLink nodeLink : treeNodeLineInfoList) {
            if (decisionLogic(matterValue, nodeLink)) return nodeLink.getNodeIdTo();
        }
        return 0L;
    }

    private boolean decisionLogic(String matterValue, TreeNodeLink nodeLink) {
        switch (nodeLink.getRuleLimitType()) {
            case 1:
                return matterValue.equals(nodeLink.getRuleLimitValue());
            case 2:
                return Double.parseDouble(matterValue) > Double.parseDouble(nodeLink.getRuleLimitValue());
            case 3:
                return Double.parseDouble(matterValue) < Double.parseDouble(nodeLink.getRuleLimitValue());
            case 4:
                return Double.parseDouble(matterValue) <= Double.parseDouble(nodeLink.getRuleLimitValue());
            case 5:
                return Double.parseDouble(matterValue) >= Double.parseDouble(nodeLink.getRuleLimitValue());
            default:
                return false;
        }
    }

    @Override
    public abstract String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);
}
