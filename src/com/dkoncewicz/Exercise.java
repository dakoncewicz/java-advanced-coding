package com.dkoncewicz;
/* Zadanie 31
Utwórz klasę rozszerzającą klasę Thread np. MyThread, przeciąż metodę run(), w której wyświetlisz w
konsoli nazwę wątku odczytując ją ze statycznej metody aktualnego wątku: Thread.currentThread().getName()
Utwórz klasę z metodą public static void main(String[] args). Wewnątrz metody main utwórz zmienną typu naszej klasy stworzonej powyżej np. MyThread oraz zainicjuj klasę.
Na zmiennej wykonać metodę start().

*/

public class Exercise {
    //
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
                System.out.println("Not enought water");
                wait();
            }
            water -=amount;
            System.out.printf("Used %d ml of water; remind %d ml\n", amount,water);
        }

        synchronized void fillWater(int amount){
            water += amount;
            notify();
            System.out.println("Water container is full. Let's make a coffee");
        }
    }

}

