
import java.util.Random;

public class Main 
{
    public static void main(String[] args) 
    {
      
        /*
            create apartments.
        */
        Apartments firstApartment = new Apartments("Bucak Mahallesi","Allahın Sokağı","Birşey Birşey apartmanı");
        Apartments secondApartment = new Apartments("Mahalle","Sokak","Apartman");
       

        /*
        Create sensors.
        */
        
        
        /*
        CREATE FACTORY
        */
        
        sensorFactory sensorFac = new ConcreteSensorFactory();
   
        /*
        CREATE BUİLDER
        */
        BuildSensor sensorBuilder = new BuildSensor();
        
        
        /*
        CREATE SENSORS VİA SENSORFACTORY.
        */
        Sensor tempSensor = sensorFac.createTemperatureSensor(0);
        Sensor polSensor = sensorFac.createPollutionSensor(0);
        Sensor noiseSensor = sensorFac.createNoiseSensor(0);
        Sensor congSensor = sensorFac.createCongestionSensor(0);
        
        Sensor tempSensor2 = sensorFac.createTemperatureSensor(0);
        Sensor polSensor2 = sensorFac.createPollutionSensor(0);
        Sensor noiseSensor2 = sensorFac.createNoiseSensor(0);
        Sensor congSensor2 = sensorFac.createCongestionSensor(0);

        
        /*
        Attach apartments to the sensor to let them notified for changes
        that are wanted to know if spesific values occurs.
        */
        tempSensor.Attach(firstApartment);
        tempSensor2.Attach(secondApartment);

        polSensor.Attach(firstApartment);
        polSensor2.Attach(secondApartment);

        noiseSensor.Attach(firstApartment);
        noiseSensor2.Attach(secondApartment);

        congSensor.Attach(firstApartment);
        congSensor2.Attach(secondApartment);


        /*
        Set sensor values randomly from codeGenerator function.
        */
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
   
      
        UI ui = new UI(); 
        
}
    public static int CodeGenerator(int i) 
    {
    Random random = new Random();
    int a = random.nextInt(i);
    return a;   
    }
}
