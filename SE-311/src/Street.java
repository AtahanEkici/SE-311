// ATAHAN EKİCİ 
// MESUT ŞİMŞEK 
// ONAT KOCABAŞOĞLU
// Smart City Application

import java.util.ArrayList;

public class Street extends Neighborhood
{
    protected String S_name;
    protected static ArrayList<Street> Street_list = new ArrayList<Street>();
    
    Street(String N_name,String S_name)
    {
        super(N_name);
        this.S_name = S_name;
        Neighborhood_list.add(this);
        Street_list.add(this);
    }
    
     @Override
        public String toString()
     {
    return " Neighborhood Name: "+N_name+" Street Name: "+S_name+"";
     }
        
         public static void Print_Street()
        { 
            for(int i = 0;i<Street_list.size();i++)
            {
                   System.out.println("");
                   System.out.println(Street_list.get(i));              
            }
        }
}
