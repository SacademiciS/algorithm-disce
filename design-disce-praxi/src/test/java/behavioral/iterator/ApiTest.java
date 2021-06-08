package behavioral.iterator;

import behavioral.iterator.design.group.Employee;
import behavioral.iterator.design.group.GroupStructure;
import behavioral.iterator.design.group.Link;
import behavioral.iterator.design.lang.Iterator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//迭代器模式
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test_iterator() {
        // 数据填充
        GroupStructure groupStructure = new GroupStructure("1", "小傅哥");

        // 雇员信息
        groupStructure.add(new Employee("2", "花花", "二级部门"));
        groupStructure.add(new Employee("3", "豆包", "二级部门"));
        groupStructure.add(new Employee("4", "蹦蹦", "三级部门"));
        groupStructure.add(new Employee("5", "大烧", "三级部门"));
        groupStructure.add(new Employee("6", "虎哥", "四级部门"));
        groupStructure.add(new Employee("7", "玲姐", "四级部门"));
        groupStructure.add(new Employee("8", "秋雅", "四级部门"));

        // 节点关系 1->(1,2) 2->(4,5)
        groupStructure.addLink("1", new Link("1", "2"));
        groupStructure.addLink("1", new Link("1", "3"));
        groupStructure.addLink("2", new Link("2", "4"));
        groupStructure.addLink("2", new Link("2", "5"));
        groupStructure.addLink("5", new Link("5", "6"));
        groupStructure.addLink("5", new Link("5", "7"));
        groupStructure.addLink("5", new Link("5", "8"));

        Iterator<Employee> iterator = groupStructure.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            logger.info("{}，雇员 Id：{} Name：{}", employee.getDesc(), employee.getuId(), employee.getName());
        }
        //从遍历的结果可以看到，我们是顺着树形结构的深度开始遍历，一直到右侧的节点3；雇员 Id：2、雇员 Id：4...雇员 Id：3
    }
    //总结：
    //迭代器的设计模式从以上的功能实现可以看到，满足了单一职责和开闭原则，外界的调用方也不需要知道任何一个不同的数据结构在使用上的遍历差异。可以非常方便的扩展，也让整个遍历变得更加干净整洁。
    //但从结构的实现上可以看到，迭代器模式的实现过程相对来说是比较负责的，类的实现上也扩增了需要外部定义的类，使得遍历与原数据结构分开。虽然这是比较麻烦的，但可以看到在使用java的jdk时候，迭代器的模式还是很好用的，可以非常方便扩展和升级。
    //以上的设计模式场景实现过程可能对新人有一些不好理解点，包括；迭代器三个和接口的定义、树形结构的数据关系、树结构深度遍历思路。这些都需要反复实现练习才能深入的理解，事必躬亲，亲历亲为，才能让自己掌握这些知识。
}