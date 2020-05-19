
import java.util.Random;

// ATAHAN EKICI //
// MESUT SIMSEK //
// ONAT KOCABASOGLU //
// Smart City Application //

public class Main 
{
    public static void main(String[] args) 
{
        Pole poleOne = new Pole("Korutürk Mahallesi","Ülker Sokak","Meriç Apartmanı");
        Pole poleTwo = new Pole("Korutürk Mahallesi","Ülker Sokak","Beyhan Apartmanı");
        Pole poleThree = new Pole("Korutürk Mahallesi","Ülker Sokak","Karhani Apartmanı");
        
        Apartments MeriçApartmanı = new Apartments("Korutürk Mahallesi ","Ülker Sokak ","Meriç Apartmanı");
        Apartments BeyhanApartmanı = new Apartments("Korutürk Mahallesi ","Ülker Sokak ","Beyhan Apartmanı");
        Apartments KarhaniApartmanı = new Apartments("Korutürk Mahallesi ","Ülker Sokak ","Karhani Apartmanı");
        
        ConcreteSensorFactory myFac = new ConcreteSensorFactory();
        BuildSensor sensorBuilder = new BuildSensor();

        Sensor pSensorOne = sensorBuilder.createPollutionSensor(myFac, 18);
        Sensor tSensorOne = sensorBuilder.createTemperatureSensor(myFac, 18);
        Sensor cSensorOne = sensorBuilder.createCongestionSensor(myFac, 18);
        Sensor nSensorOne = sensorBuilder.createNoiseSensor(myFac, 18);
        
        pSensorOne.Attach(MeriçApartmanı);
        pSensorOne.Attach_Pole(poleOne);
        
        tSensorOne.Attach(MeriçApartmanı);
        tSensorOne.Attach_Pole(poleOne);
        
        cSensorOne.Attach(MeriçApartmanı);
        cSensorOne.Attach_Pole(poleOne);
        
        tSensorOne.Attach(MeriçApartmanı);
        tSensorOne.Attach_Pole(poleOne);
        
        nSensorOne.Attach(MeriçApartmanı);
        nSensorOne.Attach_Pole(poleTwo);
        
        Sensor pSensorTwo = sensorBuilder.createPollutionSensor(myFac, 18);
        Sensor tSensorTwo =  sensorBuilder.createTemperatureSensor(myFac, 18);
        Sensor cSensorTwo = sensorBuilder.createCongestionSensor(myFac, 18);
        Sensor nSensorTwo = sensorBuilder.createNoiseSensor(myFac, 18);
        
        pSensorTwo.Attach(BeyhanApartmanı);
        pSensorTwo.Attach_Pole(poleTwo);
        
        tSensorTwo.Attach(BeyhanApartmanı);
        tSensorTwo.Attach_Pole(poleTwo);
        
        cSensorTwo.Attach(BeyhanApartmanı);
        cSensorTwo.Attach_Pole(poleTwo);
        
        tSensorTwo.Attach(BeyhanApartmanı);
        tSensorTwo.Attach_Pole(poleTwo);
        
        nSensorTwo.Attach(MeriçApartmanı);
        nSensorTwo.Attach_Pole(poleTwo);
        
        Sensor pSensorThree = sensorBuilder.createPollutionSensor(myFac, 18);
        Sensor tSensorThree = sensorBuilder.createTemperatureSensor(myFac, 18);
        Sensor cSensorThree = sensorBuilder.createCongestionSensor(myFac, 18);
        Sensor nSensorThree = sensorBuilder.createNoiseSensor(myFac, 18);
        
        pSensorThree.Attach(KarhaniApartmanı);
        pSensorThree.Attach_Pole(poleThree);
        
        tSensorThree.Attach(KarhaniApartmanı);
        tSensorThree.Attach_Pole(poleThree);
        
        cSensorThree.Attach(KarhaniApartmanı);
        cSensorThree.Attach_Pole(poleThree);
        
        nSensorThree.Attach(KarhaniApartmanı);
        nSensorThree.Attach_Pole(poleThree);
        
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

