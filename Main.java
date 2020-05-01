package com.company;

public class Main {

    public static void main(String[] args) {

        Apartments firstApartmen = new Apartments("Sahin Apartmani");
        Apartments secondApartmen = new Apartments("Yilmaz Apartmani");

        Sensor tempSensor = new Temperature_Sensor();
        Sensor polSensor = new Pollution_Sensor();
        Sensor noiseSensor = new Noise_Sensor();
        Sensor congSensor = new Congestion_Sensor();


        tempSensor.Attach(firstApartmen);
        tempSensor.Attach(secondApartmen);

        polSensor.Attach(firstApartmen);
        polSensor.Attach(secondApartmen);

        noiseSensor.Attach(firstApartmen);
        noiseSensor.Attach(secondApartmen);

        congSensor.Attach(firstApartmen);
        congSensor.Attach(secondApartmen);


        tempSensor.setSensorValue(10);
        polSensor.setSensorValue(20);
        noiseSensor.setSensorValue(50);
        congSensor.setSensorValue(60);

    }
}
