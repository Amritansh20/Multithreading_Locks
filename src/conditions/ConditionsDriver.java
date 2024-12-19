package conditions;

import semaphore.SharedResourceSemaphore;

public class ConditionsDriver {
    public static void main(String[] args) {
        SharedResourceConditions r1 = new SharedResourceConditions();

        Thread t1 = new Thread(()->{
            for(int i=0;i<2;i++){
                r1.producer();
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=0;i<2;i++){
                r1.consumer();
            }
        });

        t1.start();
        t2.start();
    }
}
