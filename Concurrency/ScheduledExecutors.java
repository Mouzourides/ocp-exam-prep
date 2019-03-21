import java.util.concurrent.*;
import java.util.Arrays;
import java.util.List;

class ScheduledExecutors {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // Does task after delay
        ScheduledFuture<String> future = service.schedule(() -> "done!", 1, TimeUnit.SECONDS);

        // Does task after initial delay and then every set amount of time --
        // 1st arg runnable task, 2nd arg initial delay, 3rd arg time period for repeat,
        // 4th time unit
        ScheduledFuture<?> future3 = service.scheduleAtFixedRate(() -> System.out.println("Hi there"), 1, 1,
                TimeUnit.SECONDS);

        // Does task after initial delay and then every set amount of time after
        // previous task finishes --
        // 1st arg runnable task, 2nd arg initial delay, 3rd arg time period for repeat,
        // 4th time unit
        ScheduledFuture<?> future2 = service.scheduleWithFixedDelay(() -> System.out.println("Hi there"), 1, 1,
                TimeUnit.SECONDS);
        System.out.println(future.get());
    }
}