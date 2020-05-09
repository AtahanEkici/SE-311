
import java.util.ArrayList;

abstract class Neighborhood 
{
    public static String Name;
    
    
    Neighborhood(String name)
    {
        this.Name = name;
    }
    
     @Override
        public String toString()
     {
    return "Neighborhood Name: "+Name+"";
     }
}
