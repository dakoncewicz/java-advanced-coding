package com.dkoncewicz;
/*
Utwórz klasę rozszerzającą klasę Thread np. MyThread, przeciąż metodę run(), w której wyświetlisz w
konsoli nazwę wątku odczytując ją ze statycznej metody aktualnego wątku:
Thread.currentThread().getName()

Utwórz klasę z metodą public static void main(String[] args).
Wewnątrz metody main utwórz zmienną typu naszej klasy stworzonej powyżej np. MyThread oraz zainicjuj klasę.
Na zmiennej wykonać metodę start().
 */

public class Exercise34 {
    public static void main(String[] args) throws InterruptedException {
        /* Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //code running within the thread
                System.out.println("we are in thread : " + Thread.currentThread().getName());
                System.out.println("thread priority : "+Thread.currentThread().getPriority());
            }
        });
         */

        Thread myThread = new MyThred();
        myThread.setName("Worker #0");
        myThread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("we are in thread : " + Thread.currentThread().getName() + " BEFORE start");
        myThread.start();
        System.out.println("we are in thread : " + Thread.currentThread().getName() + " AFTER start");

        //Thread.sleep( 1000);
    }

    private static class MyThred extends Thread {
        @Override
        public void run(){
            //code running within the thread
            System.out.println("we are in thread : " + this.getName());
        }

    }
}
