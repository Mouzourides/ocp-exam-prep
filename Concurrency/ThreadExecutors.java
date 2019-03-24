import java.util.concurrent.*;

class ThreadExecutors {
    public static void main(String[] args) {

        // Single thread executors
        ExecutorService singleService = Executors.newSingleThreadExecutor();

        // Scheduled single thread executors
        ScheduledExecutorService scheduledService = Executors.newSingleThreadScheduledExecutor();

        // Fixed size of threads pool
        ExecutorService fixedService = Executors.newFixedThreadPool(10);

        // Scheduled with fixed size of threads pool
        ScheduledExecutorService fixedScheduledService = Executors.newScheduledThreadPool(10);

        // Creates new threads as needed but will use already created thread if
        // available
        ExecutorService cachedService = Executors.newCachedThreadPool();
    }
}