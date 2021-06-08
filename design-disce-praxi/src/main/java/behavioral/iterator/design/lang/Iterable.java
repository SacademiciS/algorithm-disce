package behavioral.iterator.design.lang;

public interface Iterable<E> {
    //这个接口中提供了上面迭代器的实现Iterator的获取，也就是后续在自己的数据结构中需要实现迭代器的功能并交给Iterable，由此让外部调用方进行获取使用。
    Iterator<E> iterator();
}
