package common;

/**
 * Created by igor on 28.05.2014.
 */
public class ThreadSafeSingleton {

    private ThreadSafeSingleton() {
        System.out.println("created instance of ThreadSafeSingleton");
    }

    public static ThreadSafeSingleton getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public static class InstanceHolder {

        private static ThreadSafeSingleton INSTANCE = new ThreadSafeSingleton();

        private InstanceHolder() {
        }

    }
}