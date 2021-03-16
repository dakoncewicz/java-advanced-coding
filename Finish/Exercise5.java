package com.dkoncewicz;
/*  Zadanie 5
Zaimplementuj klasę SDAHashSet<E> , która będzie implementować logikę HashSet<E>. W tym celu
zaimplementuj obsługę metod:
• add
• remove
• size
• contains
• clear
 */

import java.util.HashSet;

public class Exercise5 {
    // Key concepts : Generics, HashSet

    public void show()
    {
        var sda = new SDAHashSet<Integer>();

        sda.add(1);
        sda.add(5);
        sda.add(3);

        System.out.println(sda.size());

        sda.remove(5);
        System.out.println(sda.size());
        System.out.println(sda.toString());

    }

    class SDAHashSet<E>{
        private HashSet<E> hashSet;

        public SDAHashSet() {
            hashSet = new HashSet<E>();
        }

        public void add(E e){
            hashSet.add(e);
        }

        public int size(){
            return hashSet.size();
        }

        public void remove(E e){ hashSet.remove(e);}

        public boolean contains(E e) {
            return hashSet.contains(e);
        }

        @Override
        public String toString() {
            return "SDAHashSet{" +
                    "hashSet=" + hashSet +
                    '}';
        }
    }
}
