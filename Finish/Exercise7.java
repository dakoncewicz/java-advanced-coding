package com.dkoncewicz;
/* Zadanie 7
Stwórz klasę imitującą magazynek do broni. Klasa powinna mieć możliwość definiowania
rozmiaru magazynka za pomocą konstruktora. Zaimplementuj metody:
 * loadBullet(String bullet) → dodawanie naboju do magazynka, nie pozwala załadować więcej naboi niż wynosi pojemność magazynka
 * isLoaded() → zwraca informację o tym czy broń jest naładowana (przynajmniej jeden nabój) czy nie
* shot() → jedno wywołanie wystrzeliwuje (wypisuje w konsoli wartość string) jeden - ostatni załadowany nabój i przygotowuje kolejny,
    załadowany przed ostatnim, jeżeli nie ma więcej nabojów to wypisuje w konsoli “pusty magazynek”
 */

public class Exercise7 {
    //key concepts : Encspsulation, Abstraction, privte fileds

    public void show(){
        var magazine = new Magazine(3);
        magazine.loadBullet("Pocisk 1");
        magazine.loadBullet("Pocisk 2");
        magazine.loadBullet("Pocisk 3");

        System.out.println(magazine.isLoaded());

        magazine.shoot();

        magazine.loadBullet("Pocisk 4");
        magazine.shoot();
        magazine.shoot();
        magazine.shoot(); // ostatni pocisk
        magazine.shoot();


    }

    class Magazine {
        private static final int MAX_CAPACITY = 20;
        private String[] bullets;
        private int capacity;
        private int index;

        public Magazine(int capacity) {
            if (capacity >= MAX_CAPACITY)
                throw new IndexOutOfBoundsException("overloading maximum capacity =" + MAX_CAPACITY);

            this.capacity = capacity;
            bullets = new String[capacity];
        }

        public boolean isLoaded(){
            return (index > 0);
        }

        public void loadBullet (String bullet){
            if (index >= capacity)
                System.out.println("magazine is full");
            else
                bullets[index++] = bullet;
            //System.out.println(bullets[index-1]);
        }

        public void shoot() {
            if (index == 0)
                System.out.println("magazine is empty");
            else {
                System.out.println(bullets[index - 1]);
                index--;
            }
        }
    }
}
