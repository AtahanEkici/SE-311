import java.util.ArrayList;
/*
    An observer that observes the Sensors.
*/
interface Observer_Apartment // Observer Pattern //
{
    public void Update(Sensor sensor);
}
/*

    Apartments is a concrete observer.

*/
public class Apartments extends Street implements Observer_Apartment
    {
        protected  String Name;
        protected static ArrayList<Apartments> list = new ArrayList<>();
     
        protected Sensor _polSensor;
        protected Sensor _tempSensor;
        protected Sensor _congSensor;
        protected Sensor _noiseSensor;

         Apartments(String N_name, String S_name, String Name)
        {
            super(N_name,S_name);
            Neighborhood_list.add(this);
            Street_list.add(this);
            this.Name = Name;
            list.add(this);    
        }
        @Override
        public String toString()
     {
         return "Neighborhood Name: "+N_name+" Street Name: "+S_name+" Apartment Name: "+Name+"";
     }
        
        public static void pushApartments(Apartments a)
        {
            list.add(a);
        }
        
        public static void Print_Apartments()
        { 
            for(int i = 0;i<list.size();i++)
            {
                   System.out.println(list.get(i));                 
            }
        }
        
        int Total_Number_Of_Apartments()
        {
            return list.size();
        }

        public static void deleteApartment(Apartments a,String Name)
{
            for(int i=0;i<list.size();i++)
            {
                if(list.get(i).equals(""+Name+""))
                {
                    list.remove(i-2);
                    list.remove(i-1);
                    list.remove(i);
                }
            }
}

    @Override
        public void Update(Sensor sensor) 
        {
             switch (sensor.sensorID()){
                 case 0:
                     _polSensor = sensor;
                     
                     /*
                     user will be notified if pollution AQI value is greater than 100.
                     */
                     
                     if(_polSensor.getSensorValue() >= 100){
                     System.out.println("Pollution is announced to " + this.Name + " as :" + sensor.getSensorValue());
                     
                     }
                     break;

                 case 1:
                     _tempSensor = sensor;
                     
                     /*
                      You get notified when temperature falls below 0 degrees
                     */
                     
                     if(_tempSensor.getSensorValue() <= 0){
                     System.out.println("Temp is announced to " + this.Name + " as :" + sensor.getSensorValue());
                     }
                     break;

                 case 2:
                     _congSensor = sensor;
                     
                     
                     /*
                        You will be announced if the Car speed blow 10km/s
                     */
                   
                     if(_congSensor.getSensorValue() <= 10){
                     System.out.println("Cong is announced to " + this.Name + " as :"+ sensor.getSensorValue());
                     }
                     break;

                 case 3:
                     _noiseSensor = sensor;
                     
                     
                       /*
                      You get notified when noise level is above 85dB
                     */
                     
                     if(_noiseSensor.getSensorValue() >= 85){
                      System.out.println("Noise is announced to " + this.Name + " as : "+ sensor.getSensorValue() );
                     }
                    
                     break;           
             }
        }

    Object getName() 
    {
        return this.Name;
    }
    }