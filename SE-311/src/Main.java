
import java.util.Random;

public class Main 
{

    public static void main(String[] args) 
    {
/*
        Apartments firstApartmen = new Apartments("Sahin Apartmani","Kahramanlar Sokağı","Bucak Mah.");
        Apartments secondApartmen = new Apartments("Yilmaz Apartmani","Kahramanlar Sokağı","Bucak Mah.");
*/
        Pole deneme = new Pole("Deneme","Deneme2","Deneme3");
        
        System.out.println(deneme);
        /*       

        Sensor tempSensor = new Temperature_Sensor();
        Sensor polSensor = new Pollution_Sensor();
        Sensor noiseSensor = new Noise_Sensor();
        Sensor congSensor = new Congestion_Sensor();


        tempSensor.Attach(firstApartmen);
        tempSensor.Attach(secondApartmen);

        polSensor.Attach(firstApartmen);
        polSensor.Attach(secondApartmen);

        noiseSensor.Attach(firstApartmen);
        noiseSensor.Attach(secondApartmen);

        congSensor.Attach(firstApartmen);
        congSensor.Attach(secondApartmen);


        tempSensor.setSensorValue(CodeGenerator(100));
        polSensor.setSensorValue(CodeGenerator(100));
        noiseSensor.setSensorValue(CodeGenerator(100));
        congSensor.setSensorValue(CodeGenerator(100));
*/
    }
    
    public static int CodeGenerator(int deger)
{
    Random random = new Random();
    int a = random.nextInt(deger);
    return a;
}  

}
