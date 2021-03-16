package com.dkoncewicz;
/* Zadanie 17
Stwórz klasę enum ConversionType ze stałymi METERS_TO_YARDS, YARDS_TO_METERS, CENTIMETERS_TO_ICHES, INCHES_TO_CENTIMETERS, KILOMETERS_TO_MILES, MILES_TO_KILOMETERS.
Enum powinien posiadać parametr typu Converter służący do przeprowadzania obliczeń dla danego typu.

Następnie stwórz klasę MeasurementConverter, która będzie posiadała metodę convert(int value, ConvertionType conversionType)
Metoda na podstawie przekazanej wartości oraz typu konwersji, korzystała z Convertera danego typu i zwracała wynik.
 */

public class Exercise17 {
    //Key concepts : Enum, implementing interface, private enum method

    public void show(){
        var mConv = new MeasurementConverter();
        var result = mConv.convert(10,ConvertionType.METERS_TO_YARDS);
        System.out.println("meters to yards : "+result);
        result = mConv.convert(result,ConvertionType.YARDS_TO_METERS);
        System.out.println("yards to meters : "+result);
    }

    interface Converter {
        double convert(double input);
    }

    enum ConvertionType {
        METERS_TO_YARDS(
                new Converter(){
                    @Override
                    public double convert(double input) {
                        return input * 1.0936133;
                    }
                }
        ),
        YARDS_TO_METERS(
                new Converter(){
                    @Override
                    public double convert(double input) {
                        return input * 0.9144;
                    }
                }
        );
        /* CENTIMETERS_TO_ICHES,
        INCHES_TO_CENTIMETERS,
        KILOMETERS_TO_MILES,
        MILES_TO_KILOMETERS;

         */

        private Converter converter;

        ConvertionType(Converter converter) {
            this.converter = converter;
        }
    }

    class MeasurementConverter {

        public double convert(double value, ConvertionType conversionType){
            return conversionType.converter.convert(value);
        }
    }
}
