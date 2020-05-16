
import java.util.Random;

public class Main 
{
    public static void main(String[] args) 
    {
      
        UI.ShowUI();
        
}
    public static int CodeGenerator(int i) 
    {
    Random random = new Random();
    int a = random.nextInt(i);
    return a;   
    }
}
