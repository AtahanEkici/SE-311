// ATAHAN EKICI //
// MESUT SIMSEK //
// ONAT KOCABASOGLU //
// Smart City Application //
import java.util.ArrayList;

public abstract class Neighborhood 
{
    protected String N_name;
    
    protected static ArrayList<Neighborhood> Neighborhood_list = new ArrayList<Neighborhood>();
    
    Neighborhood(String name)
    {
        this.N_name = name;
        Neighborhood_list.add(this);
    }
     @Override
        public String toString()
     {
    return "Neighborhood Name: "+N_name+"";
     }
        
        public static void Print_Neighborhood()
        { 
            for(int i = 0;i<Neighborhood_list.size();i++)
            {
                   System.out.println("");
                   System.out.println(Neighborhood_list.get(i));              
            }
        }
        
        int Total_Number_Of_Neighborhoods()
        {
            return Neighborhood_list.size();
        }
}