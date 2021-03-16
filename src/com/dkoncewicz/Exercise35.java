package com.dkoncewicz;
/* Zadanie 35
Utwórz klasę implementującą Runnable np. MyRunnable. Zaimplementuj metodę run(), która wyświetli
nam nazwę aktualnego wątku analogicznie jak w poprzednim ćwiczeniu.

Utwórz klasę z metodą public static void main(String[] args). Wewnątrz metody main utwórz zmienną
typu klasy stworzonej powyżej np. MyRunnable oraz zainicjuj klasę.

Utwórz zmienną typu Thread i zainicjuj ją przekazując jako parametr konstruktora implementację interfejsu Runnable.
 Na zmiennej typu Thread wykonać metodę start().
 */
public class Exercise35 {
    public static void main(String[] args) {
        //System.out.println(Thread.activeCount());
        //System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Thread.currentThread().getName());

        for(int i=0; i < 10; i++){
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }

    }

    public static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("Downloading a file "+Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Download completed "+Thread.currentThread().getName());
        }
    }
}
