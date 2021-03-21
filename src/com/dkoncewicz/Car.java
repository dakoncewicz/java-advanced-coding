package com.dkoncewicz;
/*
Class bellongs to Zadanie32
 */

public class Car implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    public int id;
    public String name;
    public String type;

    public Car(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Deserialized Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    //getters and setters etc.
}
