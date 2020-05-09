interface Observer_Apartment
{
    public void Update(Sensor sensor);
}

public class Apartments extends Street implements Observer_Apartment
    {
        protected static String Name;

        protected Sensor _polSensor;
        protected Sensor _tempSensor;
        protected Sensor _congSensor;
        protected Sensor _noiseSensor;

         Apartments(String N_name,String S_name,String Name)
        {
            super(N_name,S_name);
            Apartments.Name = Name;
        }
        @Override
        public String toString()
     {
    return "Neighborhood Name: "+N_name+" Street Name: "+S_name+" Apartment Name: "+Name+"";
     }

        public String getName(){return Apartments.Name;}

    /**
     *
     * @param sensor
     */
    @Override
        public void Update(Sensor sensor) 
        {
             switch (sensor.sensorID()){
                 case 0:
                     _polSensor = sensor;
                     System.out.println("Pollution is announced to " + Apartments.Name + " as :" + sensor.getSensorValue());
                     break;

                 case 1:
                     _tempSensor = sensor;
                     System.out.println("Temp is announced to " + Apartments.Name + " as :" + sensor.getSensorValue());
                     break;

                 case 2:
                     _congSensor = sensor;
                     System.out.println("Cong is announced to " + Apartments.Name + " as :"+ sensor.getSensorValue());
                     break;

                 case 3:
                     _noiseSensor = sensor;
                     System.out.println("Noise is announced to " + Apartments.Name + " as : "+ sensor.getSensorValue() );
                     break;           
             }

        }
    }
