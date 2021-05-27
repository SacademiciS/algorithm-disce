package structure.combination.design.service.engine;

import structure.combination.design.model.aggregates.TreeRich;
import structure.combination.design.model.vo.EngineResult;

import java.util.Map;

/**
 * @Author: wjh
 * @Description
 * @Date: 2021/5/27 11:22
 */
public interface IEngine {

    EngineResult process(final Long treeId, final String userId, TreeRich treeRich, final Map<String, String> decisionMatter);

}
