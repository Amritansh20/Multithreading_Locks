package conditions;

import java.sql.Connection;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResourceConditions {
    boolean isAvailable = false;
    ReentrantLock lock = new ReentrantLock();
    Condition condition=lock.newCondition();

    public void producer(){
        try{
            lock.lock();
            System.out.println("Producer lock is acquired by: "+Thread.currentThread().getName());

            if(isAvailable){
                System.out.println("Producer Thread is waiting: "+Thread.currentThread().getName());
                condition.await();
            }
            isAvailable=true;
            condition.signal();
        }catch (Exception e){

        }

        finally {
            lock.unlock();
            System.out.println("Producer Thread is released by: "+Thread.currentThread().getName());
        }
    }

    public void consumer(){
        try{
            Thread.sleep(3000);
            lock.lock();
            System.out.println("Consumer thread is acquired by: "+Thread.currentThread().getName());

            if(!isAvailable){
                System.out.println("Consumer Thread is waiting: "+Thread.currentThread().getName());
                condition.await();
            }
            isAvailable=false;
            condition.signal();
        }catch(Exception e){

        }

        finally {
            lock.unlock();
            System.out.println("Consumer Thread is release by: "+Thread.currentThread().getName());
        }
    }
}
