package creation.singleton;

public class Singleton1 {

    private Singleton1 singleton1;

    private Singleton1() {

    }

    public Singleton1 getInstance() {
        return singleton1;
    }
}
