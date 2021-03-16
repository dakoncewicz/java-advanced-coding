package com.dkoncewicz;
/* Zadanie 26
Wykorzystując mechanizmy programowania funkcyjnego na podstawie zadanej struktury wyświetl: 1. listę wszystkich Modelów,
2. listę wszystkich aut,
3. listę wszystkich nazw producentów,
4. listę wszystkich lat założenia producentów,
5. listę wszystkich nazw modeli,
6. listę wszystkich lat startu produkcji modeli,
7. listę wszystkich nazw aut,
8. listę wszystkich opisów aut,
9. tylko modele z parzystym rokiem startu produkcji,
10. tylko auta producentów z parzystym rokiem założenia,
11. tylko auta z parzystym rokiem startu produkcji modelu oraz nieparzystym rokiem założenia producenta, 12. tylko auta typu CABRIO z nieparzystym rokiem startu produkcji modelu i parzystym rokiem założenia
producenta,
13. tylko auta typu SEDAN z modelu nowszego niż 2019 oraz rokiem założenia producenta mniejszym niż 1919
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise26 {
    public void show(){
        //static data
        var car1 = new Car("Car A1","car A1 description",CarType.COUPE);
        var car2 = new Car("Car A2","car A2 description",CarType.CABRIO);
        var car3 = new Car("Car A2","car A3 description",CarType.SEDAN);
        var car4 = new Car("Car A4","car A4 description",CarType.COUPE);

        var car11 = new Car("Car B1","car B1 description",CarType.HATCHBACK);
        var car12 = new Car("Car B2","car B2 description",CarType.CABRIO);

        var model1 = new Model("Model1",1920, Arrays.asList(car1, car2, car3));
        var model2 = new Model("Model2",1930, Arrays.asList(car3, car4, car3));
        var modelB = new Model("ModelB",1956, Arrays.asList(car11, car12));

        var manufacture = new Manufacturer("Manufacure",1910,
                Arrays.asList(model1, model1, model2));
        var manufactureB = new Manufacturer("ManufacureB",1950,
                Arrays.asList(modelB));

        var manufactures = Arrays.asList(manufacture,manufactureB);


        //list of all cars
        var carList = manufactures.stream()
                .flatMap(m -> m.models.stream())
                .flatMap(e -> e.cars.stream())
                .map(c -> c.getName())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(carList);

        //list of all manufacturer's names
        var manufacturerNameList = manufactures.stream()
                .map(m -> m.getName())
                .collect(Collectors.toList());
        System.out.println(manufacturerNameList);

        //list of all model's name
        var modelNameList = manufactures.stream()
                .flatMap(s -> s.models.stream())
                .map(m -> m.getName())
                .collect(Collectors.toList());
        System.out.println(modelNameList);

        //list of models with even year of productionStartYear
        var modelEvenList = manufactures.stream()
                .flatMap(s -> s.models.stream())
                .filter( m -> (m.getProductionStartYear() % 2) == 0)
                .collect(Collectors.toList());
        System.out.println(modelEvenList);
    }

    //structure :
    //  Manufacturer
    //      Model
    //           Car

    enum CarType {
        COUPE, CABRIO, SEDAN, HATCHBACK
    }

    class Car {
        public String name;
        public String description;
        public CarType carType;

        public Car(String name, String description, CarType carType) {
            this.name = name;
            this.description = description;
            this.carType = carType;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", carType=" + carType +
                    '}';
        }
    }

    class Model {
        public String name;
        public int productionStartYear;
        public List<Car> cars;

        public Model(String name, int productionStartYear, List<Car> cars) {
            this.name = name;
            this.productionStartYear = productionStartYear;
            this.cars = cars;
        }

        public String getName() {
            return name;
        }

        public int getProductionStartYear() {
            return productionStartYear;
        }

        public List<Car> getCars() {
            return cars;
        }

        @Override
        public String toString() {
            return "Model{" +
                    "name='" + name + '\'' +
                    ", productionStartYear=" + productionStartYear +
                    '}';
        }
    }

    class Manufacturer {
        public String name;
        public int yearOfCreation;
        List<Model> models;

        public Manufacturer(String name, int yearOfCreation, List<Model> models) {
            this.name = name;
            this.yearOfCreation = yearOfCreation;
            this.models = models;
        }

        public String getName() {
            return name;
        }

        public int getYearOfCreation() {
            return yearOfCreation;
        }

        public List<Model> getModels() {
            return models;
        }

        @Override
        public String toString() {
            return "Manufacturer{" +
                    "name='" + name + '\'' +
                    ", yearOfCreation=" + yearOfCreation +
                    ", models=" + models +
                    '}';
        }
    }
}
