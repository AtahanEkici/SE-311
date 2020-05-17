
// ATAHAN EKİCİ 
// MESUT ŞİMŞEK 
// ONAT KOCABAŞOĞLU
// Smart City Application

import java.util.ArrayList;

interface Observer_Pole //Observer Pattern //
{
    public void Update_Pole(Sensor sensor);
}

public class Pole extends Street implements Observer_Pole
{
    @SuppressWarnings("LeakingThisInConstructor")
    
        protected  String pol_Name;
        protected static ArrayList<Pole> Pole_list = new ArrayList<>();
       
        protected Sensor _polSensor;
        protected Sensor _tempSensor;
        protected Sensor _congSensor;
        protected Sensor _noiseSensor;
    
     Pole(String N_name, String S_name, String Name)
    {
        super(N_name,S_name);
        Neighborhood_list.add(this);
        Street_list.add(this);
        this.pol_Name = Name; 
        Pole_list.add(this);
        
    }
     
     public static boolean Pol_IsExists(String name)
        {
           boolean result = false;
           
           for(int i = 0;i < Pole_list.size();i++)
           {
               if(Pole_list.get(i).pol_Name.equals(""+name+"") == true)
               {
                   result = true;
                   return result;
               }
           }
           return result;
        }
@Override
        public String toString()
     {
    return "Neighborhood Name: "+N_name+" Street Name: "+S_name+" Apartment Name: "+pol_Name+"";
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
        int Total_Number_of_Poles()
        {
            return Pole_list.size();
        }
        
    @Override
        public void Update_Pole(Sensor sensor) 
        {
             switch (sensor.sensorID()){
                 case 0:
                     _polSensor = sensor;
                     System.out.println("Pollution is announced to " + this.pol_Name + " as :" + sensor.getSensorValue());
                     break;

                 case 1:
                     _tempSensor = sensor;
                     System.out.println("Temp is announced to " + this.pol_Name + " as :" + sensor.getSensorValue());
                     break;

                 case 2:
                     _congSensor = sensor;
                     System.out.println("Cong is announced to " + this.pol_Name + " as :"+ sensor.getSensorValue());
                     break;

                 case 3:
                     _noiseSensor = sensor;
                     System.out.println("Noise is announced to " + this.pol_Name + " as : "+ sensor.getSensorValue() );
                     break;           
             }
        }

    Object getName_Pole() 
    {
        return this.pol_Name;
    }
}