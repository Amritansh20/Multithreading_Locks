package readWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDriver {

    public static void main(String[] args) {
        SharedResourceReadWriteLock r1 = new SharedResourceReadWriteLock();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        //shared lock
        Thread t1 = new Thread(()->{
            r1.producer(lock);
        });

        //shared lock
        Thread t2 = new Thread(()->{
            r1.producer(lock);
        });

        //Exclusive lock
        SharedResourceReadWriteLock r2 = new SharedResourceReadWriteLock();
        Thread t3 = new Thread(()->{
            r2.consumer(lock);
        });

        t1.start();
        t2.start();
        t3.start();
    }

}
