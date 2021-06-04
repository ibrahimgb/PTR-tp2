package com.company;

import java.util.concurrent.Semaphore;

class Thread extends java.lang.Thread
{
    Semaphore sem;
    String threadName;
    int number;
    public Thread(Semaphore sem, String threadName,int number)
    {
        super(threadName);
        this.sem = sem;
        this.threadName = threadName;
        this.number = number;
    }

    @Override
    public void run() {

        // run by thread A


            System.out.println("Starting " + threadName);
            try
            {
                // First, get a permit.
                System.out.println(threadName + " is waiting for a permit.");

                // acquiring the lock
                sem.acquire();

                System.out.println(threadName + " gets a permit.");

                // Now, accessing the shared resource.


                // other waiting threads will wait, until this
                // thread release the lock

                // TODO: 6/4/21

                for(int i=0; i < 5; i++)
                {
                    System.out.println(i+ "in therd"+ threadName);
                    // Now, allowing a context calculate.
                    Shared.arrRes[i][number]= Shared.arr1[i][number]+Shared.arr2[i][number];
                    java.lang.Thread.sleep(500);
                }
            } catch (InterruptedException exc) {

                System.out.println(exc);
            }

            // Release the permit.
            System.out.println(threadName + " releases the permit.");
            sem.release();



    }
}