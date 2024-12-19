package semaphore;

import java.awt.*;
import java.util.concurrent.Semaphore;

public class SharedResourceSemaphore {
    boolean isAvailable = false;
    Semaphore lock = new Semaphore(2);

    public void producer(){
        try{
            lock.acquire();
            System.out.println("Lock acquired by: "+Thread.currentThread().getName());
            isAvailable=true;
            Thread.sleep(4000);
        }catch (Exception e){

        }
        finally {
            lock.release();
            System.out.println("Lock released by: "+Thread.currentThread().getName());
        }
    }


}
