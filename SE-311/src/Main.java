
import java.util.Random;

public class Main 
{

    public static void main(String[] args) 
    {
        /*
        
        Apartments firstApartment = new Apartments("Bucak Mahallesi","Allahın Sokağı","Birşey Birşey apartmanı");
        Apartments secondApartment = new Apartments("Mahalle","Sokak","Apartman");
        
        System.out.println(firstApartment);
        System.out.println(secondApartment);          

        Sensor tempSensor = new Temperature_Sensor();
        Sensor polSensor = new Pollution_Sensor();
        Sensor noiseSensor = new Noise_Sensor();
        Sensor congSensor = new Congestion_Sensor();


        tempSensor.Attach(firstApartment);
        tempSensor.Attach(secondApartment);

        polSensor.Attach(firstApartment);
        polSensor.Attach(secondApartment);

        noiseSensor.Attach(firstApartment);
        noiseSensor.Attach(secondApartment);

        congSensor.Attach(firstApartment);
        congSensor.Attach(secondApartment);


        tempSensor.setSensorValue(CodeGenerator(100));
        polSensor.setSensorValue(CodeGenerator(100));
        noiseSensor.setSensorValue(CodeGenerator(100));
        congSensor.setSensorValue(CodeGenerator(100));
        */
        
        InterfacePanel ip;
        ip = new InterfacePanel();
        ip.showInterface1();

}
    private static int CodeGenerator(int i) 
    {
         Random random = new Random();
    int a = random.nextInt(i);
    return a;
    }
}
