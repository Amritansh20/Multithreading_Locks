package semaphore;

public class SemaphoreDriver {
    public static void main(String[] args) {
        SharedResourceSemaphore r1 = new SharedResourceSemaphore();

        Thread t1 = new Thread(()->{
           r1.producer();
        });

        Thread t2 = new Thread(()->{
            r1.producer();
        });

        Thread t3 = new Thread(()->{
            r1.producer();
        });

        Thread t4 = new Thread(()->{
            r1.producer();
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
