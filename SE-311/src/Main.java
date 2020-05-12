
import java.util.Random;

public class Main 
{
    public static void main(String[] args) 
    {
      
        /*
            create apartments.
        */
        Apartments firstApartment = new Apartments("Bucak Mahallesi","Allahın Sokağı","Birşey Birşey apartmanı");
        Apartments secondApartment = new Apartments("Mahalle","Sokak","Apartman1");
       

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
        
        


        
        /*
        Attach apartments to the sensor to let them notified for changes
        that are wanted to know if spesific values occurs.
        */
        tempSensor.Attach(firstApartment);
        tempSensor.Attach(secondApartment);

        polSensor.Attach(firstApartment);
        polSensor.Attach(secondApartment);
        

        noiseSensor.Attach(firstApartment);
        noiseSensor.Attach(secondApartment);

        congSensor.Attach(firstApartment);
        congSensor.Attach(secondApartment);
        


        /*
        Set sensor values to give alerts.
        */
        tempSensor.setSensorValue(-20);
        polSensor.setSensorValue(222);
        noiseSensor.setSensorValue(2222);
        congSensor.setSensorValue(1);

        
        
        /*
        Iterate over subscribed apartments collection and get the subscribed
        aperments names and print them all.
        */
        
        tempSensor.getAllSubs();
        
        
        
        
                /*
        Create a sensors class object to collect all sensors and visit them to reset.
        */
        
        Sensors sensorCollection = new Sensors();
        
        sensorCollection.add(tempSensor);
        sensorCollection.add(polSensor);
        sensorCollection.add(noiseSensor);
        sensorCollection.add(congSensor);
        
            
        //sensors visited to the admin to Reset them.
        
        sensorCollection.Accept(new ResetVisitor());
        
        
        
        
        
        
        
        
       
        
        InterfacePanel ip;
        ip = new InterfacePanel();
        ip.showInterface1();
        
        /* 
        
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
