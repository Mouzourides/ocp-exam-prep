import java.util.concurrent.*;
import java.util.stream.IntStream;

class ConcurrencyCyclicBarrier {

    private void feedAnimals(CyclicBarrier c1, CyclicBarrier c2) throws InterruptedException, BrokenBarrierException {
        System.out.println("Removing animals");
        c1.await();
        System.out.println("Cleaning the pen");
        c2.await();
        System.out.println("Adding animals");
    }

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        ExecutorService service = null;
        ConcurrencyCyclicBarrier cb = new ConcurrencyCyclicBarrier();
        CyclicBarrier c1 = new CyclicBarrier(4, () -> System.out.println("** Animals have been removed"));
        CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("** Animals have been cleaned"));
        try {
            service = Executors.newFixedThreadPool(4);
            for (int i = 0; i < 4; i++) {
                service.submit(() -> {
                    try {
                        cb.feedAnimals(c1, c2);
                    } catch (InterruptedException | BrokenBarrierException e) {
                        System.err.println(e.getStackTrace());
                    }
                });
            }
        } finally {
            if (service != null)
                service.shutdown();
        }
    }
}