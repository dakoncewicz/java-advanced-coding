package com.dkoncewicz;
/* Zadanie 16
Stwórz klasę enum Runner ze stałymi BEGINNER, INTERMEDIATE, ADVANCED. Enum powinien posiadać dwa
parametry:
• minimalny czas przebiegnięcia maratonu w minutach
• maksymalny czas przebiegnięcia maratonu w minutach

Dodatkowo enum Runner powinien zawierać metodę statyczną getFitnessLevel(),
    która przyjmuje na wejściu dowolny czas przebiegnięcia maratonu, a jako rezultat powinna zwracać
    konkretny obiekt Runner na podstawie przekazanego czasu.
 */

public class Exercise16 {
    //Key concepts : Enum, static method, iterating over enum values
    public void show(){
        System.out.println(Runner.getFitnessLevel(45));
    }

    enum Runner {
        // must be declared at first
        BEGINNER(120, 260),
        INTERMEDIATE(90, 120),
        ADVANCED(45, 65),
        UNKNOWN(0, 45);
        private int minTime;  //min time of finishing the marathon (in minutex)
        private int maxTime;  //max acceptable time for finishing the marathon (in minutex)

        Runner(int minTime, int maxTime) {
            this.minTime = minTime;
            this.maxTime = maxTime;
        }

        public static Runner getFitnessLevel(int time){
            for (Runner runner : values()){
                if( time >= runner.minTime && time <= runner.maxTime)
                    return runner;
            }
            return UNKNOWN;
        }


    }
}