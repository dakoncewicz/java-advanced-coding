package com.dkoncewicz;
/*
Stwórz klasę Manufacturer, która będzie zawierać pola: nazwa, rok założenia, kraj. Uwzględnij wszystkie
niezbędne meotody oraz parametry konstruktora. Zaimplementuj metody hashCode() i equals() .

Stwórz klasę Car , która będzie zawierać pola:
nazwa, model, cena, rok produkcji, lista producentów (Manufacturer),
oraz typ silnika (reprezentowany jako klasa enum, np. V12, V8, V6, S6, S4, S3).
Uwzględnij wszystkie niezbędne metody oraz parametry konstruktora. Zaimplementuj metody hashcode() i equals().

Stwórz klasę CarService , która będzie zawierać w sobie listę aut, oraz będzie realizować poniższe metody:
1. dodawanie aut do listy,
2. usuwanie auta z listy,
3. zwracanie listy wszystkich aut,
*/

import java.util.*;

public class Exercise {

    public void show(){
        var manufactura = new Manufacturer("VW Poland", 2010,"Polska");
        var manufactura2 = new Manufacturer("VW Poland", 2010,"Polska");
        List<Manufacturer> manList = new ArrayList<>();
        manList.add(manufactura);
        manList.add(manufactura2);
        var car1 = new Car("car1",120_000, manList, EngineTyp.V12);
        var car2 = new Car("car2",20_000, manList, EngineTyp.V8);

        var carService = new CarService();

        System.out.println(carService.sizeOf());
        carService.add(car1);
        carService.add(car1);
        carService.add(car2);
        System.out.println(carService.list);

        System.out.println(carService.sizeOf());

    }

    class Manufacturer {
        private String name;
        private int year;
        private String country;

        public Manufacturer(String name, int year, String country) {

            this.name = name;
            this.year = year;
            this.country = country;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Manufacturer that = (Manufacturer) o;
            return year == that.year && name.equals(that.name) && Objects.equals(country, that.country);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, year, country);
        }
    }

    enum EngineTyp {
        V12, V8, S4, OTHER
    }
    class Car{
        //nazwa, model, cena, rok produkcji, lista producentów (Manufacturer),
        //oraz typ silnika (reprezentowany jako klasa enum, np. V12, V8, V6, S6, S4, S3).
        private String name;
        private float price;
        private List<Manufacturer> manufacterers;
        private EngineTyp engine;

        public Car(String name, float price, List<Manufacturer> manufacterers, EngineTyp engine) {
            this.name = name;
            this.price = price;
            this.manufacterers = manufacterers;
            this.engine = engine;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Car)) return false;
            Car car = (Car) o;
            return Float.compare(car.price, price) == 0 && name.equals(car.name) && manufacterers.equals(car.manufacterers) && engine == car.engine;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price, manufacterers, engine);
        }

        @Override
        public String toString() {
            return "Car{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    class CarService {
        private List<Car> list = new ArrayList<>();

        public void add(Car car){
            list.add(car);
        }

        private void remove(int i){
            list.remove(i);
        }

        private int sizeOf(){
            return list.size();
        }

        @Override
        public String toString() {
            return "CarService{" +
                    "list=" + list +
                    '}';
        }
    }

}

