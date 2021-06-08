package behavioral.iterator.design.group;

import behavioral.iterator.design.lang.Collection;
import behavioral.iterator.design.lang.Iterator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GroupStructure implements Collection<Employee, Link> {

    private String groupId;                                                 // 组织ID，也是一个组织链的头部ID
    private String groupName;                                               // 组织名称
    private Map<String, Employee> employeeMap = new ConcurrentHashMap<String, Employee>();  // 雇员列表
    private Map<String, List<Link>> linkMap = new ConcurrentHashMap<String, List<Link>>();  // 组织架构关系；id->list
    private Map<String, String> invertedMap = new ConcurrentHashMap<String, String>();       // 反向关系链
    //以上的这部分代码稍微有点长，主要包括了对元素的添加和删除。另外最重要的是对遍历的实现 new Iterator<Employee>。
    //添加和删除元素相对来说比较简单，使用了两个map数组结构进行定义；雇员列表、组织架构关系；id->list。当元素添加元素的时候，会分别在不同的方法中向map结构中进行填充指向关系(A->B)，也就构建出了我们的树形组织关系。


    public GroupStructure(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public boolean add(Employee employee) {
        return null != employeeMap.put(employee.getuId(), employee);
    }

    public boolean remove(Employee o) {
        return null != employeeMap.remove(o.getuId());
    }

    public boolean addLink(String key, Link link) {
        invertedMap.put(link.getToId(), link.getFromId());
        if (linkMap.containsKey(key)) {
            return linkMap.get(key).add(link);
        } else {
            List<Link> links = new LinkedList<>();
            links.add(link);
            linkMap.put(key, links);
            return true;
        }
    }

    public boolean removeLink(String key) {
        return null != linkMap.remove(key);
    }

    //迭代器实现思路
    //这里的树形结构我们需要做的是深度遍历，也就是左侧的一直遍历到最深节点。
    //当遍历到最深节点后，开始遍历最深节点的横向节点。
    //当横向节点遍历完成后则向上寻找横向节点，直至树结构全部遍历完成。
    public Iterator<Employee> iterator() {

        return new Iterator<Employee>() {

            HashMap<String, Integer> keyMap = new HashMap<>();

            int totalIdx = 0;
            private String fromId = groupId;  // 雇员ID，From
            private String toId = groupId;   // 雇员ID，To

            @Override
            public boolean hasNext() {
                return totalIdx < employeeMap.size();
            }

            @Override
            public Employee next() {
                List<Link> links = linkMap.get(toId);
                int cursorIdx = getCursorIdx(toId);

                // 同级节点扫描
                if (null == links) {
                    cursorIdx = getCursorIdx(fromId);
                    links = linkMap.get(fromId);
                }

                // 上级节点扫描
                while (cursorIdx > links.size() - 1) {
                    fromId = invertedMap.get(fromId);
                    cursorIdx = getCursorIdx(fromId);
                    links = linkMap.get(fromId);
                }

                Link link = links.get(cursorIdx);
                toId = link.getToId();
                fromId = link.getFromId();
                totalIdx++;

                return employeeMap.get(link.getToId());
            }

            // 给每个层级定义宽度遍历进度
            public int getCursorIdx(String key) {
                int idx = 0;
                if (keyMap.containsKey(key)) {
                    idx = keyMap.get(key);
                    keyMap.put(key, ++idx);
                } else {
                    keyMap.put(key, idx);
                }
                return idx;
            }
        };
    }

}
