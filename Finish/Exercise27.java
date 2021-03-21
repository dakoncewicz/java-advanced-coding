package com.dkoncewicz;
/* Zadanie 27
Zaprojektuj klasę Joiner<T>, która w konstruktorze będzie przyjmowała separator (string)
oraz posiadała metodę join() pozwalającą na podanie dowolnej ilości obiektów typu T.

Metoda ta będzie zwracać stringa łącząc wszystkie przekazane elementy wywołując ich metodę toString() i oddzielać je separatorem.
np. dla Integerów oraz separatora “-” będzie zwracała: 1-2-3-4...
 */

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Exercise27 {
    //Key concepts : Generic, List, iterowanie po liscie, StringBuilder,

    public void show(){
        var jnt = new Joiner<Integer>("-");
        List<Integer> list = Arrays.asList(1,2,3,4);

        System.out.println(jnt.joiner(list));
    }

    class Joiner<T> {
        private String separator;
        private StringBuilder stringBuilder = new StringBuilder();

        public Joiner(String separator) {
            this.separator = separator;
        }

        public String joiner(List<T> list){
            /*
            // classical approach using foreach loop
            String result = "";
            for(T t : list)
                // bad practice - using a concat or "+: is more time consuming
                //result = result + t.toString() + separator;

                //instead use a String Builder
                stringBuilder.append(t.toString()).append(separator);

            return result= stringBuilder.toString();
             */

            // or use a streams concept
            return list.stream()
                    .map(n ->n.toString())
                    .collect(Collectors.joining(separator));
        }

        // this solution has separator at the end of the returned string
        // how to renove it?
        // Example : string= string.substring(0, string.length() - 1);

    }
}
