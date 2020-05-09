interface Observer_Pole
{
    public void Update_Pole(Sensor sensor);
}

public   class Pole extends Street implements Observer_Pole
{
    protected String Name;
    
        protected Sensor _polSensor;
        protected Sensor _tempSensor;
        protected Sensor _congSensor;
        protected Sensor _noiseSensor;
    
     Pole(String N_name, String S_name, String Name)
    {
        super(N_name,S_name);
        this.Name = Name;
    }
@Override
        public String toString()
     {
    return " Neighbor_Name: "+N_name+" Street_Name: "+S_name+" Pole Name: " +Name+" ";
     }

    /**
     *
     * @param sensor
     */
        public void Update_Pole(Sensor sensor) 
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


    Object getName_Pole() 
    {
        return this.Name;
    }
}