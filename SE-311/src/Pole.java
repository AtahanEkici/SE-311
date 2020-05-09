public  class Pole extends Street implements Observer
{
    public static String Pole_ID;
    
        protected Sensor _polSensor;
        protected Sensor _tempSensor;
        protected Sensor _congSensor;
        protected Sensor _noiseSensor;
    
     Pole(String Pole_ID,String S_name, String N_name)
    {
        super(S_name, N_name);
        Pole.Pole_ID = Pole_ID;
    }
     
             @Override
        public String toString()
     {
    return "Pole_ID: " +Pole_ID+" Street_Name: "+S_name+" Neighbor_Name: "+N_name+"";
     }
     
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
                     System.out.println("Pollution is announced to " + Pole.Name + " as :" + sensor.getSensorValue());
                     break;

                 case 1:
                     _tempSensor = sensor;
                     System.out.println("Temp is announced to " + Pole.Name + " as :" + sensor.getSensorValue());
                     break;

                 case 2:
                     _congSensor = sensor;
                     System.out.println("Cong is announced to " + Pole.Name + " as :"+ sensor.getSensorValue());
                     break;

                 case 3:
                     _noiseSensor = sensor;
                     System.out.println("Noise is announced to " + Pole.Name + " as : "+ sensor.getSensorValue() );
                     break;           
             }

        } 

}
