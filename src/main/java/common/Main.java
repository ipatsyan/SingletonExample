package common;

/**
 * Created by igor on 28.05.2014.
 */
public class Main {

    public static void main(String[] args) {
        ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton.getInstance();
    }
}
