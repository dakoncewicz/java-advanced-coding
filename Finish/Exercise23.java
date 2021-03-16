package com.dkoncewicz;
/* Zadanie 23
Stwórz klasę Zoo, która będzie posiadała zbiór zwierząt oraz pozwalała na otrzymywanie statystyk na temat
posiadanych zwierząt:
 - int getNumberOfAllAnimals() → zwraca liczbę wszystkich zwierząt
 - Map<String, Integer> getAnimalsCount() → zwraca liczbę zwierząt każdego gatunku
 - Map<String, Integer> getAnimalsCountSorted() → zwraca liczbę zwierząt każdego gatunku,
    posortowaną na podstawie ilości zwierząt danego gatunku, gdzie pierwszym elementem zawsze jest gatunek z największą ilością zwierząt
 - void addAnimals(String, int) → dodaje n zwierząt danego gatunku
 See ref: https://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise23 {
    //Key concepts : Maps, sortowanie hash table, Streams

    public void show(){
        var zoo = new Zoo();
        zoo.addAnimals("zebra",3);
        zoo.addAnimals("zebra",5);
        zoo.addAnimals("miś",2);
        zoo.addAnimals("lisek",10);

        System.out.println(zoo.animals);
        System.out.println("Number of aninals : " + zoo.getNumberOfAnnimals());
        System.out.println(zoo.getAnimalsCount());

        zoo.animals.entrySet().stream()
                .map( Entry -> Entry.toString())
                .forEach(v -> System.out.println(v));

        System.out.println(zoo.getAnimalsCountSorted());
    }

    class Zoo {
        //private static int numberOfAnimals = 0;
        Map<String,Integer> animals = new HashMap<>();

        public void addAnimals(String name, int num){
            Integer val = animals.get(name );
            animals.put(name, val == null ? num : val + num);
        }

        public Map<String, Integer> getAnimalsCount() {
            return animals;
        }

        public int getNumberOfAnnimals(){
            /* Using a declarative style
            int sum =0;
            for (var entry : animals.entrySet())
                sum += entry.getValue();
            return sum;
             */

            //using a stream
            return animals.values()
                    .stream()
                    .reduce(0, Integer::sum); //Terminal operation
        }                                     // eq. (a, b) -> a + b == Integer::sum

        public List<String> getAnimalsCountSorted() {

            return animals.entrySet()   // zamienia Hash Tab na postać iterowalną
                    .stream()           // zamienia na strumień
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .map( Entry -> Entry.toString())  //mapuje EntrySet na String
                    .collect(Collectors.toList());    // collect the stream elements into a data strusture eg. List
        }

    }
}
