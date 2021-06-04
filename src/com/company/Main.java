package com.company;
// java program to demonstrate
// use of semaphores Locks
import java.util.concurrent.*;


// Driver class
public class Main
{
    public static void main(String args[]) throws InterruptedException
    {


        Shared.arr[0][0] = 11; Shared.arr[0][1] = 15; Shared.arr[0][2] = 21; Shared.arr[0][3] = 9; Shared.arr[0][4] = 6;

        Shared.arr[1][0] = 1; Shared.arr[1][1] = 10; Shared.arr[1][2] = 19; Shared.arr[1][3] = 4; Shared.arr[1][4] = 5;

        Shared.arr[2][0] = 5; Shared.arr[2][1] = 7; Shared.arr[2][2] = 18; Shared.arr[2][3] = 11; Shared.arr[2][4] = 10;

        Shared.arr[3][0] = 14; Shared.arr[3][1] = 1; Shared.arr[3][2] = 1; Shared.arr[3][3] = 1; Shared.arr[3][4] = 1;

        Shared.arr[4][0] = 23; Shared.arr[4][1] = 25; Shared.arr[4][2] = 21; Shared.arr[4][3] = 22; Shared.arr[4][4] = 26;


        // creating a Semaphore object
        // with number of permits 1
        Semaphore sem = new Semaphore(1);

        // creating two threads with name A and B
        // Note that thread A will increment the count
        // and thread B will decrement the count
        Thread mt1 = new Thread(sem, "A");
        Thread mt2 = new Thread(sem, "B");
        Thread mt3 = new Thread(sem, "C");
        Thread mt4 = new Thread(sem, "D");
        Thread mt5 = new Thread(sem, "E");


        // stating threads A B C D E
        mt1.start();
        mt2.start();
        mt3.start();
        mt4.start();
        mt5.start();


        // waiting for threads A and B
        mt1.join();
        mt2.join();
        mt3.join();
        mt4.join();
        mt5.join();


        // count will always remain 0 after
        // both threads will complete their execution
        System.out.println("count: " + Shared.count);
    }
}

