package com.dkoncewicz;
/* Zadanie 3
Stwórz metodę, która jako parametr przyjmuje mapę, gdzie kluczem jest string, a wartością liczba,
    a następnie wypisuje każdy element mapy do konsoli w formacie: Klucz: <k>, Wartość: <v>.
Na końcu każdego wiersza poza ostatnim, powinien być przecinek, a w ostatnim kropka.
 */
import java.util.HashMap;
import java.util.Map;

public class Exercise3 {
    public static void show(){
        Map<String,Integer> map = new HashMap<>();
        map.put("iOS", 100);
        map.put("Android", 101);
        map.put("Java", 18);
        map.put("PHP", 0);

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            //to get key
            e.getKey();
            //and to get value
            e.getValue();
            System.out.println("Klucz : "+ e.getKey() + " Wartość : " + e.getValue());
        }
        //shorter version
        System.out.println("Shorter version");
        map.entrySet().forEach( e -> System.out.println("Klucz : "
                                + e.getKey() + " Wartość : " + e.getValue()) );

        // for alternate last row use indicator
        System.out.println("last row alter");
        int i = 0 ;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if ( i < map.keySet().size() -1 )
                System.out.println("Klucz : "+ e.getKey() + " Wartość : " + e.getValue() + ",");
            else
                System.out.println("Klucz : "+ e.getKey() + " Wartość : " + e.getValue() + ".");

            i++;
        }

    }
}
