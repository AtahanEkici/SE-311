interface Observer
{
    public void Update(Sensor sensor);
}

public abstract class Apartments extends Street implements Observer
    {
        public String A_Name;
        public String Street_name;
        protected String N_name;

        protected Sensor _polSensor;
        protected Sensor _tempSensor;
        protected Sensor _congSensor;
        protected Sensor _noiseSensor;

         Apartments(String A_Name,String Street_name, String N_name)
        {
            super(A_Name,Street_name);
            this.N_name = Neighborhood.Name;
        }
        @Override
        public String toString()
     {
    return "Apartment Name: "+Name+"";
     }

        public String getName(){return this.Name;}

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