package structure.combination.design.model.vo;

/**
 * @Author: wjh
 * @Description 树根信息
 * @Date: 2021/5/27 10:48
 */
public class TreeRoot {

    private Long treeId;        //规则树ID
    private Long treeRootNodeId;//规则树根ID
    private String treeName;    //规则树名称

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public Long getTreeRootNodeId() {
        return treeRootNodeId;
    }

    public void setTreeRootNodeId(Long treeRootNodeId) {
        this.treeRootNodeId = treeRootNodeId;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }
}
