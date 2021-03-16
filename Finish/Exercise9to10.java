package com.dkoncewicz;
/*
Zadanie 9
Stwórz klasę Point2D posiadającą pola double x, double y, gettery, settery oraz konstruktor. Następnie
stwórz klasę Circle, która będzie miała konstruktor: Circle(Point2D center, Point2D point)
Pierwszy parametr określa środek koła, drugi jest dowolnym punktem na okręgu. Na podstawie tych punktów, klasa Circle ma określać:
• promień okręgu przy wywołaniu metody double getRadius()
• obwód okręgu przy wywołaniu metody double getPerimeter()
• pole okręgu przy wywołaniu metody double getArea()

Zadanie 10
Stwórz klasę MoveDirection posiadającą pola double x, double y oraz gettery, settery i konstruktor. Stwórz
interfejs Movable posiadający metodę move(MoveDirection moveDirection).
Zaimplementuj interfejs w klasach z poprzedniego zadania (Point2D oraz Circle).
Przy wywołaniu metody move(MoveDirection moveDirection), obiekty mają zmienić swoje położenie na podstawie przekazanego kierunku (MoveDirection).

*/

import java.util.*;

public class Exercise {

    public void show(){
        var point = new Point2D(1,2);
        System.out.println(point);

        System.out.println("------- moveable ----------");
        var point2DMovable = new Point2DMovable(1,2);
        System.out.println(point2DMovable);
        point2DMovable.move( new MoveDirection(10,20));
        System.out.println(point2DMovable);

    }

    interface Movable {
        void move(MoveDirection moveDirection);
    }

    interface Resizeable {

    }

    class MoveDirection {
        private double deltaX;
        private double deltaY;

        public MoveDirection(double deltaX, double deltaY) {
            this.deltaX = deltaX;
            this.deltaY = deltaY;
        }
    }

    class Point2D {
        private double x;
        private double y;


        public Point2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point2D{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    class Point2DMovable extends Point2D implements Movable, Resizeable {

        public Point2DMovable() {
            super(0, 0);
        }

        public Point2DMovable(double x, double y) {
            super(x, y);
        }

        @Override
        public void move(MoveDirection moveDirection) {
            super.x += moveDirection.deltaX;
            super.y += moveDirection.deltaY;
        }

        @Override
        public String toString() {
            return "Point2DMovable{" +
                    "x=" + super.x +
                    ", y=" + super.y +
                    '}';
        }
    }
}