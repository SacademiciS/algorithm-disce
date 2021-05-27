package structure.combination.design.service.engine.impl;

import structure.combination.design.model.aggregates.TreeRich;
import structure.combination.design.model.vo.EngineResult;
import structure.combination.design.model.vo.TreeNode;
import structure.combination.design.service.engine.EngineBase;

import java.util.Map;

/**
 * @Author: wjh
 * @Description
 * @Date: 2021/5/27 11:41
 */
public class TreeEngineHandle extends EngineBase {
    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        //决策流程
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);
        //决策结果
        return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
    }
}
