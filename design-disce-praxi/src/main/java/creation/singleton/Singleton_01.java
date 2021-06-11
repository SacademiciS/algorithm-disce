package creation.singleton;

//懒汉式（线程不安全）
public class Singleton_01 {

    private Singleton_01 instance;

    private Singleton_01() {

    }

    public Singleton_01 getInstance() {
        if (null != instance) return instance;
        instance = new Singleton_01();
        return instance;
    }
}
