package com.dkoncewicz;
/* Zadanie 15
Stwórz klasę enum Car ze stałymi FERRARI, PORSCHE, MERCEDES, BMW, OPEL, FIAT, TOYOTA, itp.
Każdy z pojazdów ma własne parametry np. cena, moc, itp.
Enum powinien zawierać metody boolean isPremium() oraz boolean isRegular().
Metoda isPremium() powinna zwracać rezultat przeciwny od rezultatu wywołania metody isRegular().

Dodatkowo w ramach klasy enum powinna być zadeklarowana i zaimplementowana metoda boolean isFasterThan().
Metoda boolean isFasterThan() powinna przyjmować obiekt typu Car oraz wyświetlać informacje o tym, że wskazany pojazd jest szybszy bądź nie od pojazdu przekazanego w argumencie.
W tym celu skorzystaj z metody compareTo().
 */

public class Exercise15 {
    //Key concepts : Enum

    public void show(){
        var car = Car.MERCEDES;

        System.out.println( car + " is a regular ? " + car.isRegular());
        System.out.println( car + " is a premium ? " + car.isPremium());
        System.out.println( car + " is faster than Porsche ? " + car.isFasterThan(Car.PORSCHE));
    }

    enum Car {
        FERRARI, PORSCHE, MERCEDES, BMW, OPEL, FIAT, TOYOTA;

        public boolean  isPremium(){
            return this == FERRARI || this == PORSCHE || this == MERCEDES;
        }
        public boolean isRegular(){
            return ! isPremium();
        }

        public boolean isFasterThan(Car other){
            return this.compareTo(other) < 0;
            //return this.ordinal() < other.ordinal();
        }
    }
}
