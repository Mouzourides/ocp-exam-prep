import java.lang.Runnable;
import java.util.concurrent.Callable;

class ConcurrencyThreads {
    public static void main(String... args) {

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Run");
            }
        };

        // Returns void
        Runnable task1Lambda = () -> System.out.println("Run");

        // Returns value
        Callable task2 = () -> "Done";

        // Easiest way to create Thread, created Thread with runnable or callable in
        // constructor and call start() method
        new Thread(task1).start();

        // You can also implement class that extends Thread and then override the run
        // method with your logic
        new CallHomeThread().start();
    }

    private static class CallHomeThread extends Thread {
        @Override
        public void run() {
            System.out.println("ET call home");
            try {
                // Thread to sleep puts the thread to sleep for a time in miliseconds,
                // it can throw an interrupted exception
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            System.out.println("done");
        }
    }
}