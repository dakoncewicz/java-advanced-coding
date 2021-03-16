package com.dkoncewicz;
/* Zadanie 32

Napisz program, który będzie w stanie zapisać listę elementów (np. aut) do pliku w takim formacie,
aby był również w stanie odczytać ten plik i stworzyć nową listę elementów i wypisać ją w konsoli.
 */

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Exercise32 {
    // Key concepts : serialize and deserialize
    public void show(){
        String path = "/Users/darekkoncewicz/Documents/Biezace/Moje szkolenia/SDA Academy/Java - advanced/Java-advanced-coding/Assets/";
        String fileName = "Cars.txt";

        Car c1 = new Car(1,"Wolga","ruski");
        Car c2 = new Car(2,"Audi A8","luksusowy");
        Car c3 = new Car(4,"Lexus HLx","hybryda");

        try {
            FileOutputStream file = new FileOutputStream(path + fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            //method for serialization of object
            out.writeObject(c1);
            //out.writeObject(c2);
            //out.writeObject(c3);
            System.out.println("closing");
            out.flush();
            out.close();
        } catch (Exception e) {
            System.err.println(e);
        }

    }
    public class Car implements Serializable {
        private int id;
        private String name;
        private String type;

        public Car(int id, String name, String type) {
            this.id = id;
            this.name = name;
            this.type = type;
        }

        //getters and setters etc.
    }

}
