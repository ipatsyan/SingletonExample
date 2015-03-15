package common;

/**
 * Created by igor on 28.05.2014.
 */
public class NotThreadSafeSingleton {
    private static NotThreadSafeSingleton INSTANCE = null;

    public static NotThreadSafeSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NotThreadSafeSingleton();
        }
        return INSTANCE;
    }

    private NotThreadSafeSingleton() {
        System.out.println("created instance of NotThreadSafeSingleton");
    }
}
