package com.dkoncewicz;
/* adanie 8
Zaimplementuj interfejs Validator, który będzie zawierać w swojej deklaracji metodę boolean
validate(Parcel input). Stwórz klasę Parcel z parametrami:
• int xLength
• int yLength
• int zLength
• float weight
• boolean isExpress
Validator powinien weryfikować :
- czy suma wymiarów (x, y, z) nie przekracza 300,
- czy każdy z rozmiarów nie jest mniejszy niż 30,
- czy waga nie przekracza 30.0 dla isExpress=false lub 15.0 dla isExpress=true.
W przypadku błędów, powinien o nich poinformować użytkownika.
 */

import java.util.ArrayList;
import java.util.List;

public class Exercise8 {
    // key concepts : interface

    public void show(){
        var parcelValidator = new ParcelValidator();

        var parcel = new Parcel(30, 29, 300);
        parcelValidator.validate(parcel);
    }

    interface Validator {
        boolean validate(Parcel input);
    }

    class ParcelValidator implements Validator {
        private final int MAX_DIM = 30;
        private final int MAX_SUM = 300;
        private final int MAX_EXPRESS_WEIGHT = 15;
        private final int MAX_NORMAL_WEIGHT = 30;

        List<String> errList = new ArrayList<String>();

        @Override
        public boolean validate(Parcel input) {
            errList.clear();

            if( input.xLength + input.yLength + input.zLength > MAX_SUM)
                errList.add(" Suma wymiarów większa od "+MAX_SUM);
            if( input.xLength > MAX_DIM || input.yLength > MAX_DIM || input.zLength > MAX_DIM)
                errList.add(" Każdy wymiar musi być mniejszy niż "+ MAX_DIM);
            if (errList.size() > 0 ) {
                errList.forEach( e -> System.out.println(e));
                return false;
            }
            return true;
        }
    }

    class Parcel {
        int xLength;
        int yLength;
        int zLength;
        float weight;
        boolean isExpress;

        public Parcel(int xLength, int yLength, int zLength) {
            this.xLength = xLength;
            this.yLength = yLength;
            this.zLength = zLength;
        }
    }
}
