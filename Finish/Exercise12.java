package com.dkoncewicz;
/* Zadanie 12
Stwórz klasę Manufacturer, która będzie zawierać pola: nazwa, rok założenia, kraj.
Uwzględnij wszystkie niezbędne meotody oraz parametry konstruktora.
Zaimplementuj metody hashCode() i equals() .
Stwórz klasę Car , która będzie zawierać pola: nazwa, model, cena, rok produkcji,
    lista producentów (Manufacturer), oraz typ silnika (reprezentowany jako
    klasa enum, np. V12, V8, V6, S6, S4, S3). Uwzględnij wszystkie niezbędne metody oraz parametry konstruktora.
Zaimplementuj metody hashcode() i equals().
 */

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Exercise12 {
    //Key concepts : Composition, method overriding

    public void show(){
        var m1 = new Manufacturer("Audi AG",1912,"Germany");
        var m2 = new Manufacturer("Audi Poland",2005,"Poland");
        var m3 = new Manufacturer("Audi Poland",2005,"Poland");
        var car = new Car("Audi A4","Sedan",122000, Arrays.asList(m1, m2),EngineType.V8);
        System.out.println("m1 hashCoe : " + m1.hashCode());
        System.out.println("m2 hashCoe : " + m2.hashCode());

        System.out.println(m1.equals(m2));
        System.out.println(m2.equals(m3));

        System.out.println(car.manufacturers);
    }

    class Manufacturer {
        private String name;
        private int year;
        private String countr;


        public Manufacturer(String name, int year, String countr) {
            this.name = name;
            this.year = year;
            this.countr = countr;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getCountr() {
            return countr;
        }

        public void setCountr(String countr) {
            this.countr = countr;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Manufacturer that = (Manufacturer) o;
            return getYear() == that.getYear() && getName().equals(that.getName()) && getCountr().equals(that.getCountr());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName(), getYear(), getCountr());
        }
    }

    enum EngineType {
        V12, V8, V6, S6, S4, S3
    }
    class Car{
        private String name;
        private String model;
        private float price;
        List<Manufacturer> manufacturers;
        private EngineType engine;

        public Car(String name,
                   String model,
                   float price,
                   List<Manufacturer> manufacturers,
                   EngineType engine) {
            this.name = name;
            this.model = model;
            this.price = price;
            this.manufacturers = manufacturers;
            this.engine = engine;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public List<Manufacturer> getManufacturers() {
            return manufacturers;
        }

        public void setManufacturers(List<Manufacturer> manufacturers) {
            this.manufacturers = manufacturers;
        }

        public EngineType getEngine() {
            return engine;
        }

        public void setEngine(EngineType engine) {
            this.engine = engine;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return Float.compare(car.price, price) == 0 && name.equals(car.name) && model.equals(car.model) && Objects.equals(manufacturers, car.manufacturers) && engine == car.engine;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, model, price, manufacturers, engine);
        }
    }

}
