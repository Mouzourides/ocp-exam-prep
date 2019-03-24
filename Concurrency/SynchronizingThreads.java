import java.util.concurrent.atomic.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;

class SyncronizingThreads {

    private int number;

    // Can also synchronize methods
    private synchronized void printNumSync() {
        if (number == 3)
            number = 0;
        System.out.print(++number);
    }

    private void printNum() {
        if (number == 3)
            number = 0;
        System.out.print(++number);
    }

    public static void main(String[] args) {
        // Threads accessing the same data can be problematic due to them not being
        // aware of each other. Three threads whos job it is to increment a value and
        // print it could return a number of different results, e.g. 1, 1, 2 or 2, 1, 2.

        // This is why synchronizing shared data between threads is important, to make
        // sure threads always have a correct view of the world and be aware of each
        // other

        // There are a number of wrappers around primitives that are atomic, ensures it
        // carries out its operation without any interference from other threads

        AtomicInteger num = new AtomicInteger(0);
        AtomicBoolean bool = new AtomicBoolean();

        // This will create up to three threads that will increment the atomic integer,
        // the result will always be ordered correctly and each thread will always know
        // what the correct value of theint is due to the atomic int forcing each thread
        // to wait until its incremented the value before allowing a new thread access
        ExecutorService service = Executors.newCachedThreadPool();
        // IntStream.range(1, 4).forEachOrdered((i) -> service.submit(() ->
        // System.out.print(num.incrementAndGet()))); // outputs
        // 123
        SyncronizingThreads s = new SyncronizingThreads();

        // Synchronized blocks also only allow one thread in at a time, any object can
        // be used in a synchronized block
        synchronized (s) {
            // do thread safe stuff
        }

        IntStream.range(1, 4).forEach((i) -> service.submit(() -> s.printNum())); // can print 213 or 312 or anything
        IntStream.range(1, 4).forEach((i) -> service.submit(() -> s.printNumSync())); // always 123

        service.shutdown();
    }
}