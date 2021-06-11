package creation.singleton;

//双重锁校验（线程安全）
public class Singleton_05 {

    private static volatile Singleton_05 instance;

    private Singleton_05() {

    }

    public static Singleton_05 getInstance() {
        if (null != instance) return instance;
        synchronized (Singleton_05.class) {
            if (null == instance) {
                instance = new Singleton_05();
            }
        }
        return instance;
    }
}
//双重锁的方式是方法级锁的优化，减少了部分获取实例的耗时。
//同时这种方式也满足了懒加载。
