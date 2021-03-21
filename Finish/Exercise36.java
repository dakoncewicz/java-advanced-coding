package com.dkoncewicz;
/* Zadanie 36
Utwórz klasę ThreadPlaygroundRunnable implementującą interfejs Runnable posiadająca pole name typu String
z konstruktorem publicznym dla tego pola. Klasa powinna zaimplementować metodę run() z interfejsu Runnable.
Metoda ta powinna zawierać pętlę liczącą do 10 oraz drukować nazwę aktualnego wątku korzystając z
Thread.currentThread().getName(), nazwę nadaną w konstruktorze oraz numer aktualnie wykonywanej iteracji pętli.

Utwórz klasę, która ma dwa prywatne statyczne pola typu Thread (wątek) oraz standardową metodę
public static void main(String[] args). Następnie zainicjuj pola typu Thread używając konstruktora, przyjmującego
obiekt Runnable i przekaż ThreadPlaygroundRunnable tworząc go za pomocą konstruktora, za każdym razem podając inną nazwę.

Na każdym z wątków (Thread) użyj metody start().
 */

public class Exercise36 {
    private static Thread thread1;
    private static Thread thread2;

    public static void main(String[] args) {
        thread1 = new Thread( new ThreadPlaygroundRunnable("thread__1"));
        thread2 = new Thread( new ThreadPlaygroundRunnable("thread__2"));

        thread2.start();
        thread1.start();
    }
}

class ThreadPlaygroundRunnable implements Runnable {
    String name;

    public ThreadPlaygroundRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i<10; i++){
            System.out.println(Thread.currentThread().getName()+" : "+name +" : "+i);
        }
    }
}
