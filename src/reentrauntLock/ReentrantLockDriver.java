package reentrauntLock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDriver {

    public static void main(String[] args) {
        ReentrantLock lock =  new ReentrantLock();
        SharedResourceReentrantLock r1 = new SharedResourceReentrantLock();

        Thread t1 = new Thread(()->{
             r1.produce(lock);
        });

        SharedResourceReentrantLock r2 = new SharedResourceReentrantLock();

        Thread t2 = new Thread(()->{
            r2.produce(lock);
        });

        t1.start();
        t2.start();
    }
}
