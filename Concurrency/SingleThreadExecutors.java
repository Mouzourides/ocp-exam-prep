import java.util.concurrent.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

class SingleThreadExecutors {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        // ExecutorService is not autoclosable so have to write it like this
        ExecutorService service = null;
        try {
            // Creates 1 new thread for tasks to run on, if multiple tasks they'll run
            // sequentially, will always be ordered 1 then 2
            service = Executors.newSingleThreadExecutor();
            service.execute(() -> System.out.println("1"));
            service.execute(() -> System.out.println("2"));

            // submit(Callable) method takes a Callable and returns a future
            // A future will at some point return the value returned by the callable
            Future<String> future = service.submit(() -> "Done!");
            // get() will attempt to get the value from the future, it has an overload which
            // takes an amount of time to wait before it throws an TimeoutException
            String result = future.get(2, TimeUnit.SECONDS);
            System.out.println(result);

            future.isDone(); // checks if done
            future.isCancelled(); // checks if cancelled
            future.cancel(true); // tries to cancel, takes boolean to decide if it should interrupt if the task
                                 // is currently running

            List<Callable<String>> callableList = Arrays.asList(() -> "1", () -> "2", () -> "3");

            // Executes all of a collection of tasks and returns list of futures
            List<Future<String>> futures1 = service.invokeAll(callableList);

            // Executes a collection of tasks and returns the one that successfully finishes
            String any = service.invokeAny(callableList);
            System.out.println(any);
        } finally {
            // shutdown() stops anymore threads being submitted. Can check if a thread is
            // shutdown or terminated with isShutdown(): boolean, isTerminated(): boolean
            if (service != null)
                service.shutdown();
        }
    }
}