package com.dkoncewicz;
/* Zadanie 37
Stwórz klasę zawierającą standardową metodę statyczną main oraz zmienną typu Executor i korzystając z
metody fabrykującej newFixedThreadPool klasy Executors utwórz pulę executorów o rozmiarze 2.

W iteracji dodaj do Executora 10 obiektów klasy ThreadPlaygroundRunnable z poprzedniego zadania.
Jako nazwy użyj dowolnego ciągu znaków oraz numeru aktualnej iteracji.
 */

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Exercise37 {
    public static void main(String[] args) {
        var executor = Executors.newFixedThreadPool(2);
        /*
        // Runable object -single task to execute
        executor.submit( ()-> System.out.println( Thread.currentThread().getName()));

        //to stop needs to directly call shutDown()
        executor.shutdown();

         */

        // run set of tasks within a pool
        try{
            for (int i = 0; i < 5; i++) {
                executor.submit(new ThreadPlaygroundRunnable("thread__"+1));
            }
        }
        finally {
            //best practicies - shutDown the task after exit a try{}- catch- finally block
            executor.shutdown();
        }
    }
}
