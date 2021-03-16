package com.dkoncewicz;
/*
Zadanie 18
Stwórz klasę Computer posiadającą pola określające cechy komputera:
procesor, ram, karta grafiki, firma oraz model.
Zaimplementuj settery, gettery, konstruktor z wszystkimi polami, metody toString() oraz equals() i hashcode().

Zadanie 19
Stwórz klasę Laptop rozszerzającą klasę Computer. Klasa Laptop powinna dodatkowo zawierać parametr bateria.
Zaimplementuj dodatkowe gettery, settery, konstruktor oraz odpowiednio nadpisz metody toString() oraz
equals() i hashcode().
Użyj odniesienia do metod klasy nadrzędne

 */

import java.util.Objects;

public class Exercise18to19 {
    //Key concepts : Inheritance, method overriding, super keyword;

    public void show(){
        var c1 = new Computer("int8i2", 4,"","Jakiś stary model");
        System.out.println("Komputer : "+ c1.getProcessor() +"  " +c1.getRam() + "GB RAM " + c1.getModel());

    }

    class Computer {
        //procesor, ram, karta grafiki, firma oraz model.
        private String processor;
        private int ram;
        private String graphCard;
        private String model;

        public Computer(String processor, int ram, String graphCard, String model) {
            this.processor = processor;
            this.ram = ram;
            this.graphCard = graphCard;
            this.model = model;
        }

        public Computer() {
        }

        public String getProcessor() {
            return processor;
        }

        public void setProcessor(String processor) {
            this.processor = processor;
        }

        public int getRam() {
            return ram;
        }

        public void setRam(int ram) {
            this.ram = ram;
        }

        public String getGraphCard() {
            return graphCard;
        }

        public void setGraphCard(String graphCard) {
            this.graphCard = graphCard;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Computer computer = (Computer) o;
            return ram == computer.ram && processor.equals(computer.processor) && Objects.equals(graphCard, computer.graphCard) && model.equals(computer.model);
        }

        @Override
        public int hashCode() {
            return Objects.hash(processor, ram, graphCard, model);
        }
    }

    class Laptop extends Computer {
        private String battery;

        public Laptop(String processor, int ram, String graphCard, String model, String battery) {
            super(processor, ram, graphCard, model);
            this.battery = battery;
        }

        public String getBattery() {
            return battery;
        }

        public void setBattery(String battery) {
            this.battery = battery;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Laptop laptop = (Laptop) o;
            return battery.equals(laptop.battery);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), battery);
        }
    }

}
