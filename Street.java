public class Street extends Neighborhood
{
    public static String S_name;
    protected String N_name;
    
    Street(String name,String N_name)
    {
        super(name);
        this.N_name = Neighborhood.Name;
    }
    
     @Override
        public String toString()
     {
    return "Street Name: "+Name+"";
     }
}
