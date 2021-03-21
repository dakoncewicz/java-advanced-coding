package com.dkoncewicz;
/* Zadanie 25
Zamień wyjątki BasketFullException oraz BasketEmptyException z poprzedniego zadania na wyjątki typu
unchecked exception. Obsłuż je.
*/

import java.lang.reflect.Array;

public class Exercise25 {
    //Key concepts : Exceptions, runtime exceptions

    public void show(){
        var basket = new Basket();

        try {
            for (int i=1; i <= 4; i++ )
                basket.addToBasket(3);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Basket is out of Range");
            // e.printStackTrace();
        }
    }

    class Basket {
        private final int MAX_ELEMENT = 3;
        int[] elements = new int[MAX_ELEMENT];
        int index;

        public void addToBasket (Integer elem)  {
            elements[index++]= elem;
        }

        public int removeFromBasket(){
            return elements[index--];
        }
    }
}
