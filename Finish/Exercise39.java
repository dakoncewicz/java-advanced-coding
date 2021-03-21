package com.dkoncewicz;
/* Zadanie 39
Istnieje system przechowujący aktualne wyniki w zawodach. Wiele ekranów odczytuje aktualne wyniki,
natomiast kilka czujników aktualizuje te wyniki. Napisz program, który pozwala na nieprzerwany odczyt danych
przez wiele ekranów (wątków) oraz aktualizację danych przez wiele czujników (wątków).

Aby zaktualizować wyniki, czujnik musi przekazać aktualne wyniki wraz z nowymi. System następnie weryfikuje
czy czujnik miał aktualne dane i aktualizuje dane. Jeżeli w tym czasie dane w systemie zmieniły się,
aktualizacja danych przez czujnik jest odrzucona.

Dla ułatwienia możesz przyjąć, że czujnik odczytuje dane, czeka losową ilość czasu i zwiększa dane o losową wartość.

 */

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Exercise39 {
    // Key concepts : Synchronized Collection

    public static void main(String[] args) {
        var sportRates = new SportRates();
        var screen1 = new Thread( new ScreenRunnable(1,sportRates));
        var sensor1 = new SensorRunnable(1,350,sportRates);
        var sensor2 = new SensorRunnable(2, 600,sportRates);

        sensor1.start();
        sensor2.start();
        screen1.start();

    }

    static class SportRates {

        private Map<String,Integer> sportRatesStream =  Collections.synchronizedMap(new HashMap<String,Integer>());

        public void addRate(String sensor, Integer newValue){
            Integer val = sportRatesStream.get(sensor);
            sportRatesStream.put(sensor, val == null ? newValue : val + newValue);
        }

        public Map<String, Integer> getAllRates(){
            return sportRatesStream;
        }
    }

    static class SensorRunnable extends Thread implements Runnable {
        int sensorNumber;
        int delay;                                  // in milisec
        SportRates sportRates;

        public SensorRunnable(int sensorNumber, int delay, SportRates sportRates) {
            this.sensorNumber = sensorNumber;
            this.delay = delay;
            this.sportRates = sportRates;
        }

        @Override
        public void run() {
            for (; ; ) {
                try {
                    Thread.sleep(delay);
                    sportRates.addRate("sensor"+sensorNumber, (int)(Math.random()*100));
                    // screen1.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    static class ScreenRunnable extends Thread implements Runnable{
        int screenNumber;
        SportRates sportRates;

        public ScreenRunnable(int screenNumber, SportRates sportRates) {
            this.screenNumber = screenNumber;
            this.sportRates = sportRates;
        }

        @Override
        public void run() {
            try {
                for(;;) {
                    Thread.sleep(200);
                    System.out.println("Screen : "+this.screenNumber+" : "+sportRates.getAllRates());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}