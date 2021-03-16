package com.dkoncewicz;
/* Zadanie 14
Na podstawie 100000 elementowej tablicy z losowo wybranymi wartościami zaimplementuj następujące funkcjonalności:
1. zwróć listę unikalnych elementów,
2. zwróć listę elementów, które co najmniej raz powtórzyły się w wygenerowanej tablicy,
3. zwróć listę 25 najczęściej powtarzających się elementów.
Zaimplementuj metodę, która deduplikuje elementy w liście.
W przypadku znalezienia duplikatu, zastępuje go nową losową wcześniej nie występującą wartością.

Sprawdź czy metoda zadziałała poprawnie wywołując metodę numer 2.
 */

import java.util.*;
import java.util.stream.Collectors;

public class Exercise14 {
    //Key concepts : Generics, Collection Lists, Set, set operations

    public void show(){
        List<Integer> values = new ArrayList<>();
        Collections.addAll(values, 1,3,5,7,3,5,3,3,2,9,2,34);
        //List<Integer> values = genRandomList();

        Set<Integer> deduplicated = new HashSet<>(values);
        Set<Integer> duplicated = new HashSet<>();
        Set<Integer> unique = new HashSet<>();
/*
        for (Integer value : values) {
            if ( !deduplicated.add(value))
                duplicated.add(value);
        }

 */
        duplicated = findDuplicates(values);
        unique.addAll(values);
        unique.removeAll(duplicated);

        System.out.println("duplicated : " + duplicated );
        System.out.println("Unique : "+ unique );
        System.out.println("Deduplicated : "+ deduplicated);
        System.out.println("above the limit : "+ upperToLimit(values, 2));
    }


    private <T> Set<T> findDuplicates(Collection<T> collection) {
        Set<T> uniques = new HashSet<>();
        return collection.stream()
                .filter(e -> !uniques.add(e))
                .collect(Collectors.toSet());
    }

    private  Map<Integer,Integer> upperToLimit(List<Integer> list, int limit) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer e : list) {
            Integer val = map.get(e);
            map.put(e, val == null ? 1 : val + 1);
        }

        /*
        //but this loop does not work - throws runtime excepton >try to use while ( hasNext() )
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if ( e.getValue() < limit)
               map.put(e.getKey(), -1);
        }
         */

        map.entrySet().removeIf(entry -> entry.getValue() < limit);
        return map;
    }

    private List<Integer> genRandomList(){
        final int MAX_GEN = 1000;
        var random = new Random();
        var gen = new ArrayList<Integer>();
        for (int i = 0; i < MAX_GEN ; i++)
            gen.add( random.nextInt(MAX_GEN*2/3));
        return gen;
    }

    /*
    See : https://stackoverflow.com/questions/19031213/java-get-most-common-element-in-a-list
     */
}
