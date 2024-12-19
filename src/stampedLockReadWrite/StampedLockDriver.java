package stampedLockReadWrite;

public class StampedLockDriver {
    public static void main(String[] args) {
        SharedResourceStamped r1 = new SharedResourceStamped();
        Thread t1 = new Thread(()->{
           r1.producer();
        });

        Thread t2 = new Thread(()->{
            r1.producer();
        });

        Thread t3 = new Thread(()->{
            r1.consumer();
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
