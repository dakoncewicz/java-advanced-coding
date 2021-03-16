package com.dkoncewicz;
/*
Zadanie 1
Stwórz metodę, która jako parametr przyjmuje listę stringów, następnie zwraca tą listę
posortowaną alfabetycznie od Z do A.
Zadanie 2
Zmodyfikuj metodę tak aby nie brała pod uwagę wielkości liter
 */

import java.sql.SQLOutput;
import java.util.*;

public class Exercise1to2 {

    public static void show(){
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "c", "C", "B", "y","x","z");


        // list.replaceAll(String::toLowerCase);
        list.replaceAll(e -> e.toLowerCase());
        Collections.reverse(list);

        System.out.println("Exercise 1 sort list demo");
        System.out.println(list);

    }

}

/*
    Collections.sort(listed, new Comparator<Object>() {

        @Override
        public int compare(Object o1, Object o2) {
            return -o1.getLeft().compareTo(o2.getLeft());
        }
    });

 */