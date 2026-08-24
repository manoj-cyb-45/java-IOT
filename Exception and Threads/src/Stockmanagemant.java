import java.util.concurrent.locks.ReentrantLock; // Import lock class for thread safety

public class Stockmanagemant {

    // Shared resource class to hold stock value
    public static class Count {
        int stock; // variable to store stock count
    }

    // Thread class to add values to stock
    static class adder extends Thread {
        Count count; // shared object
        ReentrantLock lock; // lock for synchronization

        // Constructor to initialize shared object and lock
        public adder(Count count, ReentrantLock lock) {
            this.count = count;
            this.lock = lock;
        }

        // Run method executed when thread starts
        public void run() {
            for (int i = 0; i <= 10000; i++) {
                lock.lock(); // acquire lock before updating
                count.stock += i; // add i to stock
                lock.unlock(); // release lock after update
            }
        }
    }

    // Thread class to subtract values from stock
    static class subtractor extends Thread {
        Count count; // shared object
        ReentrantLock lock; // lock for synchronization

        // Constructor to initialize shared object and lock
        public subtractor(Count count, ReentrantLock lock) {
            this.count = count;
            this.lock = lock;
        }

        // Run method executed when thread starts
        public void run() {
            for (int i = 0; i <= 10000; i++) {
                lock.lock(); // acquire lock before updating
                count.stock -= i; // subtract i from stock
                lock.unlock(); // release lock after update
            }
        }
    }

    // Main method — entry point of program
    public static void main(String[] args) throws Exception {
        Count count = new Count(); // create shared object
        count.stock = 0; // initialize stock to 0

        ReentrantLock lock = new ReentrantLock(); // create lock object

        adder ad = new adder(count, lock); // create adder thread
        ad.start(); // start adder thread

        subtractor sub = new subtractor(count, lock); // create subtractor thread
        sub.start(); // start subtractor thread

        ad.join(); // wait for adder thread to finish
        sub.join(); // wait for subtractor thread to finish

        System.out.println(count.stock); // print final stock value
    }
}
