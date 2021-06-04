package com.company;
// java program to demonstrate
// use of semaphores Locks
import java.util.concurrent.*;


// Driver class
public class Main
{
    public static void main(String[] args) throws InterruptedException
    {


        Shared.arr1[0][0] = 11; Shared.arr1[0][1] = 15; Shared.arr1[0][2] = 21; Shared.arr1[0][3] = 9; Shared.arr1[0][4] = 6;
        Shared.arr1[1][0] = 1; Shared.arr1[1][1] = 10; Shared.arr1[1][2] = 19; Shared.arr1[1][3] = 4; Shared.arr1[1][4] = 5;
        Shared.arr1[2][0] = 5; Shared.arr1[2][1] = 7; Shared.arr1[2][2] = 18; Shared.arr1[2][3] = 11; Shared.arr1[2][4] = 10;
        Shared.arr1[3][0] = 14; Shared.arr1[3][1] = 1; Shared.arr1[3][2] = 1; Shared.arr1[3][3] = 1; Shared.arr1[3][4] = 1;
        Shared.arr1[4][0] = 23; Shared.arr1[4][1] = 25; Shared.arr1[4][2] = 21; Shared.arr1[4][3] = 22; Shared.arr1[4][4] = 26;


        Shared.arr2[0][0] = 1; Shared.arr2[0][1] = 5; Shared.arr2[0][2] = 2; Shared.arr2[0][3] = 19; Shared.arr2[0][4] = 16;
        Shared.arr2[1][0] = 5; Shared.arr2[1][1] = 7; Shared.arr2[1][2] = 9; Shared.arr2[1][3] = 6; Shared.arr2[1][4] = 15;
        Shared.arr2[2][0] = 11; Shared.arr2[2][1] = 14; Shared.arr2[2][2] = 8; Shared.arr2[2][3] = 16; Shared.arr2[2][4] = 13;
        Shared.arr2[3][0] = 23; Shared.arr2[3][1] = 15; Shared.arr2[3][2] = 17; Shared.arr2[3][3] = 18; Shared.arr2[3][4] = 12;
        Shared.arr2[4][0] = 3; Shared.arr2[4][1] = 5; Shared.arr2[4][2] = 25; Shared.arr2[4][3] = 24; Shared.arr2[4][4] = 6;

        // creating a Semaphore object
        // with number of permits 1
        Semaphore sem = new Semaphore(5);

        // creating two threads with name A and B
        // Note that thread A will increment the count
        // and thread B will decrement the count
        Thread mt1 = new Thread(sem, "A",0);
        Thread mt2 = new Thread(sem, "B",1);
        Thread mt3 = new Thread(sem, "C",2);
        Thread mt4 = new Thread(sem, "D",3);
        Thread mt5 = new Thread(sem, "E",4);


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

