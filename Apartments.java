/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;


interface Observer{
    public void Update(Sensor sensor);
}


public class Apartments implements Observer
    {
        public String Name;

        protected Sensor _polSensor;
        protected Sensor _tempSensor;
        protected Sensor _congSensor;
        protected Sensor _noiseSensor;


         Apartments(String Name)
        {
            this.Name = Name;
        }







        @Override
        public String toString()
     {
    return "Apartment Name: "+Name+"";
     }




        public String getName(){return this.Name;}



        @Override
        public void Update(Sensor sensor) {

             switch (sensor.sensorID()){
                 case 0:
                     _polSensor = sensor;
                     System.out.println("Pollution is announced to " + this.Name + " as :" + sensor.getSensorValue());
                     break;

                 case 1:
                     _tempSensor = sensor;
                     System.out.println("Temp is announced to " + this.Name + " as :" + sensor.getSensorValue());
                     break;

                 case 2:
                     _congSensor = sensor;
                     System.out.println("Cong is announced to " + this.Name + " as :"+ sensor.getSensorValue());
                     break;

                 case 3:
                     _noiseSensor = sensor;
                     System.out.println("Noise is announced to " + this.Name + " as : "+ sensor.getSensorValue() );
                     break;

             }

        }
    }