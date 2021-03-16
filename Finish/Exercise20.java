package com.dkoncewicz;
/* Zadanie 20
Stwórz abstrakcyjną klasę Shape wraz z abstrakcyjnymi metodami calculatePerimeter() służącą do
obliczania obwodu oraz calculateArea() służącą do obliczania powierzchni.
Stwórz klasy Rectangle, Triangle, Hexagon, rozszerzając klasę Shape, odpowiednio implementując metody abstrakcyjne.
Sprawdź poprawność działania.
*/

import java.util.*;

public class Exercise {
    // Key concepts : Inheritance, Polimorphizm
    public void show(){
        var rectangle = new Rectangle();
        var triangle = new Triangle();
        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(rectangle);
        shapeList.add(triangle);

        for(Shape shape : shapeList) {
            shape.calculateArea();
            System.out.println(shape.calculatePerimeter());
        }
    }

    abstract class  Shape{
        private String color;

        public abstract double calculatePerimeter();
        public double calculateArea(){
            System.out.println("Shape Area");
            return 0;
        }
    }

    class Rectangle extends Shape {

        @Override
        public double calculateArea() {
            System.out.println("Rectangle Area");
            return 0;
        }

        @Override
        public double calculatePerimeter() {
            return 10;
        }
    }

    class Triangle extends Shape {
        @Override
        public double calculateArea() {
            System.out.println("Triangle area");
            return 0;
        }

        @Override
        public double calculatePerimeter() {
            return 20;
        }
    }
}

