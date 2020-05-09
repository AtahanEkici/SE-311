abstract class Neighborhood 
{
    protected static String N_name;
    String Street;
    String Pole_ID;
    
    Neighborhood(String name)
    {
        Neighborhood.N_name = name;
        
    }
    
     @Override
        public String toString()
     {
    return "Neighborhood Name: "+N_name+"";
     }
}
