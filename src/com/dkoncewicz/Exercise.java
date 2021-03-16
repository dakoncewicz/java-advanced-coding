package com.dkoncewicz;
/* Zadanie 24
Stwórz klasę Basket, która imituje koszyk i przechowuje aktualną ilość elementów w koszyku.
Dodaj metodę addToBasket(), która dodaje element do koszyka (zwiększając aktualny stan o 1) oraz
metodę removeFromBasket(), która usuwa element z koszyka (zmniejszając aktualny stan o 1).
Koszyk może przechowywać od 0 do 10 elementów. W przypadku, kiedy użytkownik chce wykonać
akcję usunięcia przy stanie 0 lub dodania przy stanie 10, rzuć odpowiedni checked exception (BasketFullException lub BasketEmptyException).
 */


import java.util.*;
import java.util.stream.Collectors;

public class Exercise {
    public void show(){
        var basket = new Basket();
        try {
            for (int i = 0; i < 12 ; i++)
                basket.addToBasket(1);

            System.out.println(basket.elements[0]);
        } catch (Basket.BasketFullException e) {
            e.printStackTrace();
        }

        System.out.println(" after exception");
    }
class Basket {
        private final int MAX_BASKET = 10;
        int[] elements = new int[MAX_BASKET];
        int count;

        public void addToBasket(int elem) throws BasketFullException {
            if(count == MAX_BASKET)
                throw new BasketFullException ("EX: Basket is full");
            elements[count++] = elem;
        }

        private class BasketFullException extends Exception {
            public BasketFullException(String message) {
                super(message);
            }
        }
}

}

