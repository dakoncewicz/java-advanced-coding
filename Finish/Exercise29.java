package com.dkoncewicz;
/* Zadanie 29
Zaimplementuj generyczną metodę partOf, która na podstawie tablicy dowolnego typu
oraz wskazanej funkcji jako parametrów zwróci % elementów spełniających warunek.

 */

import javax.xml.validation.Validator;
import java.util.ArrayList;

public class Exercise29 {
    // Key concepts : array of generics, initiation of static array,
    // passing a function to a method
    public void show(){
        var array = new Integer[] {1,2,3,4,5,6,7,9,12};
        var val = new Validator<Integer>() {
            @Override
            public boolean validate(Integer value) {
                return value % 3 == 0;
            }
        };
        var percent = Utils.partOf(array, val);
        System.out.println(percent*100 +" %");

    }

    interface Validator<T> {
        boolean validate(T value);
    }


    public static class Utils<T> {

        public static <T> double partOf(T[] tab, Validator<T> val){
            int counter = 0;

            //for( "Type of iterable" "element" : "Collection | Array etc" )
            for( T element : tab)
                if( val.validate(element)) counter++;

            return (double)counter/tab.length;
        }
    }
}
