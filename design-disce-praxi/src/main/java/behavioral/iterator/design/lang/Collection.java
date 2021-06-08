package behavioral.iterator.design.lang;

//这里我们定义集合操作接口；Collection，同时继承了另外一个接口Iterable的方法iterator()。这样后续谁来实现这个接口，就需要实现上述定义的一些基本功能；添加元素、删除元素、遍历。
//同时你可能注意到这里定义了两个泛型<E, L>，因为我们的数据结构一个是用于添加元素，另外一个是用于添加树节点的链路关系。
public interface Collection<E, L> extends Iterable<E> {

    boolean add(E e);

    boolean remove(E e);

    boolean addLink(String key, L l);

    boolean removeLink(String key);

    Iterator<E> iterator();
}
