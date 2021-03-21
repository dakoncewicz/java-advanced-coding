package com.dkoncewicz;
/* Zadanie 32

Napisz program, który będzie w stanie zapisać listę elementów (np. aut) do pliku w takim formacie,
aby był również w stanie odczytać ten plik i stworzyć nową listę elementów i wypisać ją w konsoli.
 */

import java.io.*;

public class Exercise32 {
    // Key concepts : serialization and deserialization
    public void show(){
        String path = "Assets/";
        String fileName = "Cars.txt";

        Car c1 = new Car(1,"Wolga","ruski");
        Car c2 = new Car(2,"Audi A8","luksusowy");
        Car c3 = new Car(4,"Lexus HLx","hybryda");

        //Serialization
        try {
            //saving of object ina file
            FileOutputStream fileOut = new FileOutputStream(path+fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            //method for serialization of object
            out.writeObject(c1);
            out.writeObject(c2);
            out.writeObject(c3);
            System.out.println("objects have been serialized");
            out.flush();
            out.close();
        } catch (Exception e) {
            System.err.println(e);
        }

        //deserialization
        try {
            var fileIn = new FileInputStream(path + fileName);
            var in = new ObjectInputStream(fileIn);

            //method for deserialization of object
            Car c1ToDeserialize = (Car)in.readObject();
            Car c2ToDeserialize = (Car)in.readObject();
            Car c3ToDeserialize = (Car)in.readObject();

            System.out.println("deserialization");
            System.out.println(c1ToDeserialize);
            System.out.println(c2ToDeserialize);
            System.out.println(c3ToDeserialize);
            in.close();
            fileIn.close();
        } catch (Exception e) {
            System.err.println(e);
        }

    }

}
