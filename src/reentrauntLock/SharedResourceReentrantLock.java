package reentrauntLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResourceReentrantLock {
    boolean isAvailable=false;

    public void produce(ReentrantLock lock){
        try{
            lock.lock();
            System.out.println("Lock acquired by: "+ Thread.currentThread().getName());
            isAvailable=true;
            Thread.sleep(4000);
        }catch (Exception e){

        }

        finally{
            lock.unlock();
            System.out.println("Lock released by: "+ Thread.currentThread().getName());
        }
    }

}
