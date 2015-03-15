import static org.junit.Assert.assertEquals;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

import common.ThreadSafeSingleton;

/**
 * Created by igor on 28.05.2014.
 */

public class ThreadSafeSingletonTest {

    public static final int THREAD_POOL = 3;

    public static final int THREAD_COUNT = 3;

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(THREAD_POOL);

    @Test
    public void testThreadSafeSingleton() throws InterruptedException, ExecutionException {
        List<Callable<ThreadSafeSingleton>> callables = new LinkedList<Callable<ThreadSafeSingleton>>();
        for (int i = 0; ++i < THREAD_COUNT; ) {
            callables.add(new Callable<ThreadSafeSingleton>() {
                @Override
                public ThreadSafeSingleton call() {
                    return ThreadSafeSingleton.getInstance();
                }
            });
        }

        List<Future<ThreadSafeSingleton>> futures = EXECUTOR_SERVICE.invokeAll(callables);
        Set<ThreadSafeSingleton> singletons = new LinkedHashSet<ThreadSafeSingleton>();

        for (Future<ThreadSafeSingleton> future : futures) {
            singletons.add(future.get());
        }
        assertEquals("Singleton is not thread-safe!", 1, singletons.size());
    }

}
