package com.dkoncewicz;
/* Zadanie 28
Rozszerz klasę ArrayList<E> implementując metodę getEveryNthElement().
Metoda ta zwraca listę elementów oraz przyjmuje dwa parametry: indeks elementu od którego zaczyna oraz liczbę określającą co który element ma wybierać.

Dla listy: [a, b, c, d, e, f, g] oraz parametrów: startIndex=3 i skip=3
zwróci listę [c, g]
 */

import java.lang.reflect.Array;
import java.util.*;

public class Exercise28 {
    //Key concepts : extensions of Generics

    public void show(){
        NewArrayList<Character> list = new NewArrayList<>();
        var collection = new ArrayList<Character>();
        Collections.addAll(collection, 'a','b','c','d','e','f','g');
        list.addAll(collection);
        /*list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');

         */
        System.out.println(list);

        System.out.println(list.getEveryNthElement(3,4));
    }

    class NewArrayList<E> extends ArrayList<E> {

        public ArrayList<E> getEveryNthElement(int startIndex, int skip){
            ArrayList<E> list = new ArrayList<>();

            for(var i=startIndex-1; i < this.size(); i += skip+1)
                list.add(this.get(i));

            return list;
        }
    }
}
