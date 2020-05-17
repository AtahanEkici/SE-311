// ATAHAN EKİCİ 
// MESUT ŞİMŞEK 
// ONAT KOCABAŞOĞLU
// Smart City Application

public class Main 
{
    public static void main(String[] args) 
{
        Pole poleOne = new Pole("Korutürk Mahallesi","Ülker Sokak","Pole 1");
        Pole poleTwo = new Pole("Korutürk Mahallesi","Ülker Sokak","Pole 2");
        Pole poleThree = new Pole("Korutürk Mahallesi","Ülker Sokak","Pole 3");
        
        Apartments MeriçApartmanı = new Apartments("Korutürk Mahallesi ","Ülker Sokak ","Meriç Apartmanı");
        Apartments BeyhanApartmanı = new Apartments("Korutürk Mahallesi ","Ülker Sokak ","Beyhan Apartmanı");
        Apartments KarhaniApartmanı = new Apartments("Korutürk Mahallesi ","Ülker Sokak ","Karhani Apartmanı");
        
        Sensor pSensorOne = new Pollution_Sensor(18);
        Sensor tSensorOne = new Temperature_Sensor(25);
        Sensor cSensorOne = new Congestion_Sensor(2);
        Sensor nSensorOne = new Noise_Sensor(0);
        
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
        
        Sensor pSensorTwo = new Pollution_Sensor(18);
        Sensor tSensorTwo = new Temperature_Sensor(25);
        Sensor cSensorTwo = new Congestion_Sensor(2);
        Sensor nSensorTwo = new Noise_Sensor(0);
        
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
        
        Sensor pSensorThree = new Pollution_Sensor(18);
        Sensor tSensorThree = new Temperature_Sensor(25);
        Sensor cSensorThree = new Congestion_Sensor(2);
        Sensor nSensorThree = new Noise_Sensor(0);
        
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
        
}
}