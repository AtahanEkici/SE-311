
import java.util.Random;

// ATAHAN EKICI //
// MESUT SIMSEK //
// ONAT KOCABASOGLU //
// Smart City Application //

public class Main 
{
    public static void main(String[] args) 
{
        Pole poleOne = new Pole("Korutürk Mahallesi","Ülker Sokak","poleOne");
        Pole poleTwo = new Pole("Korutürk Mahallesi","Ülker Sokak","poleTwo");
        Pole poleThree = new Pole("Korutürk Mahallesi","Ülker Sokak","poleThree");
        
        Apartments MeriçApartmanı = new Apartments("Korutürk Mahallesi ","Ülker Sokak ","Meriç Apartmanı");
        Apartments BeyhanApartmanı = new Apartments("Korutürk Mahallesi ","Ülker Sokak ","Beyhan Apartmanı");
        Apartments KarhaniApartmanı = new Apartments("Korutürk Mahallesi ","Ülker Sokak ","Karhani Apartmanı");
        
        ConcreteSensorFactory myFac = new ConcreteSensorFactory();
        BuildSensor sensorBuilder = new BuildSensor();

        Sensor pSensorOne = sensorBuilder.createPollutionSensor(myFac, 18);
        Sensor tSensorOne = sensorBuilder.createTemperatureSensor(myFac, 18);
        Sensor cSensorOne = sensorBuilder.createCongestionSensor(myFac, 18);
        Sensor nSensorOne = sensorBuilder.createNoiseSensor(myFac, 18);
        
        Sensor pSensorOne_pol = sensorBuilder.createPollutionSensor(myFac, 18);
        Sensor tSensorOne_pol = sensorBuilder.createTemperatureSensor(myFac, 18);
        Sensor cSensorOne_pol = sensorBuilder.createCongestionSensor(myFac, 18);
        Sensor nSensorOne_pol = sensorBuilder.createNoiseSensor(myFac, 18);
        
        Sensor pSensorTwo = sensorBuilder.createPollutionSensor(myFac, 18);
        Sensor tSensorTwo = sensorBuilder.createTemperatureSensor(myFac, 18);
        Sensor cSensorTwo = sensorBuilder.createCongestionSensor(myFac, 18);
        Sensor nSensorTwo = sensorBuilder.createNoiseSensor(myFac, 18);
        
        Sensor pSensorTwo_pol = sensorBuilder.createPollutionSensor(myFac, 18);
        Sensor tSensorTwo_pol = sensorBuilder.createTemperatureSensor(myFac, 18);
        Sensor cSensorTwo_pol = sensorBuilder.createCongestionSensor(myFac, 18);
        Sensor nSensorTwo_pol = sensorBuilder.createNoiseSensor(myFac, 18);
        
        Sensor pSensorThree = sensorBuilder.createPollutionSensor(myFac, 18);
        Sensor tSensorThree = sensorBuilder.createTemperatureSensor(myFac, 18);
        Sensor cSensorThree = sensorBuilder.createCongestionSensor(myFac, 18);
        Sensor nSensorThree = sensorBuilder.createNoiseSensor(myFac, 18);
        
        Sensor pSensorThree_pol = sensorBuilder.createPollutionSensor(myFac, 18);
        Sensor tSensorThree_pol = sensorBuilder.createTemperatureSensor(myFac, 18);
        Sensor cSensorThree_pol = sensorBuilder.createCongestionSensor(myFac, 18);
        Sensor nSensorThree_pol = sensorBuilder.createNoiseSensor(myFac, 18);
        

        pSensorOne.Attach(MeriçApartmanı);
        pSensorOne_pol.Attach_Pole(poleOne);
        
        tSensorOne.Attach(MeriçApartmanı);
        tSensorOne_pol.Attach_Pole(poleOne);
        
        cSensorOne.Attach(MeriçApartmanı);
        cSensorOne_pol.Attach_Pole(poleOne);
 
        nSensorOne.Attach(MeriçApartmanı);
        nSensorOne_pol.Attach_Pole(poleOne);
        
        
        
        pSensorTwo.Attach(BeyhanApartmanı);
        pSensorTwo_pol.Attach_Pole(poleTwo);
        
        tSensorTwo.Attach(BeyhanApartmanı);
        tSensorTwo_pol.Attach_Pole(poleTwo);
        
        cSensorTwo.Attach(BeyhanApartmanı);
        cSensorTwo_pol.Attach_Pole(poleTwo);
           
        nSensorTwo.Attach(BeyhanApartmanı);
        nSensorTwo_pol.Attach_Pole(poleTwo);
        
        
        
        pSensorThree.Attach(KarhaniApartmanı);
        pSensorThree_pol.Attach_Pole(poleThree);
        
        tSensorThree.Attach(KarhaniApartmanı);
        tSensorThree_pol.Attach_Pole(poleThree);
        
        cSensorThree.Attach(KarhaniApartmanı);
        cSensorThree_pol.Attach_Pole(poleThree);
        
        nSensorThree.Attach(KarhaniApartmanı);
        nSensorThree_pol.Attach_Pole(poleThree);
        
        
       // Singleton proof //
        UI ui = UI.getInstance();
        UI ui2 = UI.getInstance(); // Only One Frame will be on display //
        UI ui3 = UI.getInstance();
        
        System.out.println(ui);
        System.out.println(ui2);
        System.out.println(ui3);//you should see frame0 in all the calls //
        // Singleton Proof //
        
        InterfacePanel ip1 = new InterfacePanel();
        ip1.showInterface1();
}
}

