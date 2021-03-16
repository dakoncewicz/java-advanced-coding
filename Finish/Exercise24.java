package com.dkoncewicz;
/* Zadanie 24
Stwórz klasę Basket, która imituje koszyk i przechowuje aktualną ilość elementów w koszyku.
Dodaj metodę addToBasket(), która dodaje element do koszyka (zwiększając aktualny stan o 1) oraz
metodę removeFromBasket(), która usuwa element z koszyka (zmniejszając aktualny stan o 1).

Koszyk może przechowywać od 0 do 10 elementów. W przypadku, kiedy użytkownik chce wykonać akcję usunięcia przy stanie 0
lub dodania przy stanie 10, rzuć odpowiedni runtime exception (BasketFullException lub BasketEmptyException).
 */

import java.lang.reflect.Array;

public class Exercise24 {
    //Key concepts : Exceptions, runtime exceptions

    public void show(){
        var basket = new Basket();

        try {
            for (int i=1; i <= 4; i++ )
                basket.addToBasket(3);

        } catch (BasketFullException e) {
            e.printStackTrace();
        }
    }

    class Basket {
        private final int MAX_ELEENT = 3;
        int[] elements = new int[MAX_ELEENT];
        int index;

        public void addToBasket (Integer elem) throws BasketFullException {
            if(index == MAX_ELEENT)
                throw new BasketFullException(" Basket is full. Cannot add new element");
            elements[index++]= elem;
        }

        public int removeFromBasket() throws BasketEmptyException {
            if (index < 0)
                throw new BasketEmptyException("Basket is empty");
            return elements[index--];
        }
    }

    private class BasketFullException extends Exception {
        public BasketFullException(String message) {
            super(message);
        }
    }

    private class BasketEmptyException extends Exception {
        public BasketEmptyException(String message) {
            super(message);
        }
    }
}
