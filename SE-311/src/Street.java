public class Street extends Neighborhood
{
    protected  String S_name;
    
    Street(String N_name,String S_name)
    {
        super(N_name);
        this.S_name = S_name;    
    }
    
     @Override
        public String toString()
     {
    return " Neighborhood Name: "+N_name+" Street Name: "+S_name+"";
     }
}
