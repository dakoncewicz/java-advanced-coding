package com.dkoncewicz;
/* Zadanie 4
Stwórz klasę Storage, która będzie miała prywatne pole typu Map, publiczny konstruktor oraz metody:
- addToStorage(String key, String value) → dodawanie elementów do przechowywalni
- printValues(String key) → wyświetlanie wszystkich elementów pod danym kluczem
- findValues(String value) → wyświetlanie wszystkich kluczy, które mają podaną wartość

Klasa Storage powinna pozwalać na przechowywanie wielu wartości pod jednym kluczem.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise4 {
    //Key concepts : Encapsulation, List of Classes, Collections, Streams
    public void show(){
        Storage s = new Storage();
        s.addToStorage("key1", "value 1");
        s.addToStorage("key2", "value 2");
        s.addToStorage("key2", "value 3");
        s.print();
        System.out.println("----------------");
        s.printValues("key2");
        System.out.println("----------------");
        s.printValuesStrem("key2");
    }

    class Storage {
        private class Map {
            String key;
            String value;

            public Map(String key, String value) {
                this.key = key;
                this.value = value;
            }
        };
        private List<Map> storage;
        private int size = 0;

        public Storage() {
            storage= new ArrayList<>();
        }

        public void addToStorage(String key, String value){
            var elem = new Map(key, value);
            storage.add(elem);
        }

        public void printValues(String key) {
            for(Map elem : storage ) {
                if (elem.key.equals(key))
                    System.out.println(elem.key + " : " + elem.value);
            }
        }

        //streams version
        public void printValuesStrem(String key) {
            storage.stream()
                    .filter( s -> s.key.equals(key))
                    .forEach(s -> System.out.println(s.key + " : " + s.value));
        }
        public void print(){
            storage.forEach(s -> System.out.println(s.key + " : " + s.value));
        }
    }
}
