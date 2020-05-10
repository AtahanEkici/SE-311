import java.util.ArrayList;

interface Observer_Apartment // Observer Pattern //
{
    public void Update(Sensor sensor);
}



public  class Apartments extends Street implements Observer_Apartment
    {
       @SuppressWarnings("LeakingThisInConstructor")
    
       public static final String ANSI_BLUE = "\u001B[34m";
       public static final String ANSI_RESET = "\u001B[0m";
       public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    
        protected String Name;
        protected static ArrayList<Apartments> list = new ArrayList<>();
     
        protected Sensor _polSensor;
        protected Sensor _tempSensor;
        protected Sensor _congSensor;
        protected Sensor _noiseSensor;

         Apartments(String N_name, String S_name, String Name)
        {
            super(N_name,S_name);
            list.add(this);
            this.Name = Name;
        }
        @Override
        public String toString()
     {
         return "Neighborhood Name: "+ANSI_BLUE+ANSI_BLACK_BACKGROUND+ ""+N_name+"" +ANSI_RESET+" Street Name: "+ANSI_BLUE+ANSI_BLACK_BACKGROUND+ ""+S_name+"" + ANSI_RESET+" Apartment Name: "+ANSI_BLUE+ANSI_BLACK_BACKGROUND+ ""+Name+"" + ANSI_RESET+"";
     }
        
        public static void pushApartments(Apartments a)
        {
            list.add(a);
        }
        
        public static void Print_Apartments()
        {
            int counter = 1;
            
            for(int i = 0;i<list.size();i++)
            {
                if(counter % 3 == 0)
                {
                    System.out.println("");
                   System.out.println(list.get(i));
                }
                
                else
                {
                System.out.println(list.get(i));
                System.out.println("");
                counter++;
                } 
            }
        }
        
        public void CreateApartment()
        {
           //Apartments apartments = new Apartments();
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

    Object getName() 
    {
        return this.Name;
    }
    }