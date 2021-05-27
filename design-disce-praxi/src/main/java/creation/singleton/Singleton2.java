package creation.singleton;

public class Singleton2 {

    private Singleton2 singleton = null;

    private Singleton2() {
    }

    public Singleton2 getInstance() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}
