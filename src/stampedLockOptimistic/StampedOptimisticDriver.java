package stampedLockOptimistic;

import stampedLockOptimistic.SharedResourceStampedOptimistic;

public class StampedOptimisticDriver {
    public static void main(String[] args) {
        SharedResourceStampedOptimistic r1 = new SharedResourceStampedOptimistic();

        Thread t1 = new Thread(()->{
            r1.producer();
        });

        Thread t2 = new Thread(()->{
            r1.consumer();
        });

        t1.start();
        t2.start();
    }
}
