package stampedLockOptimistic;

import java.util.concurrent.locks.StampedLock;

public class SharedResourceStampedOptimistic {
    int a=10;
    StampedLock lock = new StampedLock();

    public void producer(){
        long stamp = lock.tryOptimisticRead();
        try{
            System.out.println("Taken optimistic lock");
            a=11;
            Thread.sleep(6000);
            if(lock.validate(stamp)){
                System.out.println("updated a value successfully");
            }else{
                System.out.println("rollback of work");
                a=10;
            }
        }catch (Exception e){

        }
    }

    public void consumer(){
        long stamp = lock.writeLock();
        System.out.println("Lock acquired by: "+Thread.currentThread().getName());
        try{
            System.out.println("Performing work");
            a =9;
        }

        finally {
            lock.unlockWrite(stamp);
            System.out.println("Write lock is released by: "+Thread.currentThread().getName());
        }
    }
}
