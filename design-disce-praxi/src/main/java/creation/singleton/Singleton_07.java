package creation.singleton;

//枚举单例(线程安全)
public enum Singleton_07 {

    INSTANCE;
    public void test(){
        System.out.println("hi~");
    }

}
//约书亚·布洛克（英语：Joshua J. Bloch，1961年8月28日－），美国著名程序员。他为Java平台设计并实作了许多的功能，曾担任Google的首席Java架构师（Chief Java Architect）。
//Effective Java 作者推荐使用枚举的方式解决单例模式，此种方式可能是平时最少用到的。
//这种方式解决了最主要的；线程安全、自由串行化、单一实例。