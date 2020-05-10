
import java.util.Random;

public class Main 
{
    public static void main(String[] args) 
    {
        /*
        Apartments firstApartment = new Apartments("Bucak Mahallesi","Allahın Sokağı","Birşey Birşey apartmanı");
        Apartments secondApartment = new Apartments("Mahalle","Sokak","Apartman");
        Apartments dummy = new Apartments("dummy","dummy","dummy");
        
        
        System.out.println(firstApartment);
        System.out.println(secondApartment);          

        Sensor tempSensor = new Temperature_Sensor();
        Sensor polSensor = new Pollution_Sensor();
        Sensor noiseSensor = new Noise_Sensor();
        Sensor congSensor = new Congestion_Sensor();
        
        Sensor tempSensor2 = new Temperature_Sensor();
        Sensor polSensor2 = new Pollution_Sensor();
        Sensor noiseSensor2 = new Noise_Sensor();
        Sensor congSensor2 = new Congestion_Sensor();

        tempSensor.Attach(firstApartment);
        tempSensor2.Attach(secondApartment);

        polSensor.Attach(firstApartment);
        polSensor2.Attach(secondApartment);

        noiseSensor.Attach(firstApartment);
        noiseSensor2.Attach(secondApartment);

        congSensor.Attach(firstApartment);
        congSensor2.Attach(secondApartment);


        tempSensor.setSensorValue(CodeGenerator(100));
        polSensor.setSensorValue(CodeGenerator(100));
        noiseSensor.setSensorValue(CodeGenerator(100));
        congSensor.setSensorValue(CodeGenerator(100));
        
        tempSensor2.setSensorValue(CodeGenerator(100));
        polSensor2.setSensorValue(CodeGenerator(100));
        noiseSensor2.setSensorValue(CodeGenerator(100));
        congSensor2.setSensorValue(CodeGenerator(100));
        
        InterfacePanel ip;
        ip = new InterfacePanel();
        ip.showInterface1();
        
        
        
        Pole firstpole = new Pole("Deneme Mahalle","Deneme Sokak","Deneme Direk Adı"); 
        Pole.PrintPoles();
        
        Sensor.ShowAllSensors();
        Apartments.Print_Apartments();
                
        */
      
        UI ui = new UI(); 
}
    public static int CodeGenerator(int i) 
    {
    Random random = new Random();
    int a = random.nextInt(i);
    return a;   
    }
}
