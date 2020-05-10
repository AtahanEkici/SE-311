public abstract class Neighborhood 
{
    protected String N_name;
    protected String Street;
    protected String Pole_ID;
    
    Neighborhood(String name)
    {
        this.N_name = name;
    }
    
     @Override
        public String toString()
     {
    return "Neighborhood Name: "+N_name+"";
     }
}