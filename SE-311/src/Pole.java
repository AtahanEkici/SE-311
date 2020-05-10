import java.util.ArrayList;

interface Observer_Pole //Observer Pattern //
{
    public void Update_Pole(Sensor sensor);
}

public class Pole extends Street implements Observer_Pole
{
    @SuppressWarnings("LeakingThisInConstructor")
    
       public static final String ANSI_BLUE = "\u001B[34m";
       public static final String ANSI_RESET = "\u001B[0m";
       public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    
        protected String Name;
        protected static ArrayList<Pole> Pole_list = new ArrayList<>();
       
        protected Sensor _polSensor;
        protected Sensor _tempSensor;
        protected Sensor _congSensor;
        protected Sensor _noiseSensor;
    
     Pole(String N_name, String S_name, String Name)
    {
        super(N_name,S_name);
        Pole_list.add(this);
        this.Name = Name; 
    }
@Override
        public String toString()
     {
    return "Neighborhood Name: "+ANSI_BLUE+ANSI_BLACK_BACKGROUND+ ""+N_name+"" +ANSI_RESET+" Street Name: "+ANSI_BLUE+ANSI_BLACK_BACKGROUND+ ""+S_name+"" + ANSI_RESET+" Apartment Name: "+ANSI_BLUE+ANSI_BLACK_BACKGROUND+ ""+Name+"" + ANSI_RESET+"";
     }
        
        public static void PrintPoles()
        {
            int counter = 1;
            
            for(int i = 0;i<Pole_list.size();i++)
            {
                if(counter % 3 == 0)
                {
                    System.out.println("");
                   System.out.println(Pole_list.get(i));
                }
                
                else
                {
                System.out.println(Pole_list.get(i));
                System.out.println("");
                counter++;
                } 
            }
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