package com.dkoncewicz;
/* Zadanie 38

Napisz aplikację, która będzie symulować maszynę do robienia kawy.
W przypadku, gdy dowolna cykliczna usługa parzenia kawy zastanie pusty zbiornik na wodę, powinno nastąpić wstrzymanie wątku.
W momencie, gdy w maszynie zostanie uzupełniona woda, powinno nastąpić wzbudzenie wątku.
 */

public class Exercise38 {
    //Key concepts : synchronization block, thread signaling with : wait() and notify()
    public static void main(String[] args) {
        var coffeeMachine = new CoffeeMachine(1000);

        Thread makeLatte = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    try {
                        Thread.sleep(800);
                        coffeeMachine.getWater(250);
                        System.out.println("Latte is made. Please take a cup");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread makeEspresso= new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    try {
                        Thread.sleep(400);
                        coffeeMachine.getWater(80);
                        System.out.println("Espresso is made. Please take a cup");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread topUpWater = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    try {
                        Thread.sleep(3000);
                        coffeeMachine.fillWater(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        makeLatte.start();
        makeEspresso.start();
        topUpWater.start();
    }

    static class CoffeeMachine {
        private int water; // in mililiter

        public CoffeeMachine(int water) {
            this.water = water;
        }

        synchronized void getWater(int amount) throws InterruptedException {
            while( water < amount) {
                System.out.println("Not enought water. Pleas refill water container");
                wait();
            }
            water -=amount;
            System.out.printf("Used %d ml of water; remind %d ml\n", amount,water);
        }

        synchronized void fillWater(int amount){
            water += amount;
            notify();
            System.out.println("Water container is fully again. Let's make a coffee!!");
        }
    }
}
