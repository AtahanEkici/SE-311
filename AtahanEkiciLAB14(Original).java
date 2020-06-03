
package AtahanEkiciLAB14;

import static AtahanEkiciLAB14.Grades.Grades_List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

abstract class Grades 
{ 
    public static ArrayList<Integer> Grades_List = new ArrayList<>();
 
    public static ArrayList<String> ProcessGrade(ArrayList<Integer> list)
    {
         ArrayList <String> Stringlist = new ArrayList<>();
        
        for(int i = 0; i<list.size();i++)
        {
              if(list.get(i) < 60)
        {
            Stringlist.add("F");
        }
        
        else if(list.get(i) < 70)
        {
            Stringlist.add("D");
        }
        
        else if(list.get(i) < 80)
        {
            Stringlist.add("C");
        }
        
        else if(list.get(i) < 90)
        {
            Stringlist.add("B");
        }
        
        else if(list.get(i) < 101)
        {
            Stringlist.add("A");
        } 
        }  
        
        return Stringlist;
    }
    
public static int GradeGenerator()
{
  int i;
  
  Random rand = new Random();
  
  i = rand.nextInt(100);
  
  return i;
}

   public static ArrayList SortList(ArrayList<Integer> list)
   {
       Collections.sort(list);
       return list;
   }

public static int calculateMedian(ArrayList<Integer> a)
{
    int Median;
    int value;
    
    if(a.size() % 2 == 0)
    {
        value = (a.size() / 2);
        Median = a.get(value) + a.get(value+1);
        return Median;
    }
    
    else
    {
        value = (a.size() - 1) / 2;
        value++;
        Median = a.get(value);
        return Median;
    }
}

public static void disregardZero_Hundred(ArrayList<Integer> list)
{
    for(int i = 0; i < list.size(); i++)
    {
        if(list.get(i) == 100)
        {
            list.remove(i);
        }
        
        else if(list.get(i) == 0)
        {
            list.remove(i);
        }
    }
}


}

interface Interface
{
   public void  Show_Grades(ArrayList a);
   public void PopulateGrades(ArrayList<Integer> a);
}

class Access_Grades extends Grades implements Interface
{   
    @Override
    public void Show_Grades(ArrayList a) 
    {
        int counter = 0;
        
        for(int i = 0; i<a.size(); i++)
        {
            System.out.print(" "+counter+")"+a.get(i)+"");
            counter++;
        }
        System.out.println("\n");
    }

    @Override
    public void PopulateGrades(ArrayList<Integer> a) 
    {
       a.add(59);
       a.add(61);
       a.add(25);
       a.add(99);
       a.add(100);
       a.add(0);
       a.add(69);
       a.add(82);
    }
}

class Main
{
    public static void main(String[] args) 
{
    InterfacePanel ip1 = new InterfacePanel();
    ip1.showInterface1();
}
}

  class InterfacePanel
    {
        private final Interface interface1;
      
        public InterfacePanel()
        {
            interface1 = new Access_Grades();
        }
        public void showInterface1()
        {
            interface1.PopulateGrades(Grades_List);
            Access_Grades.SortList(Grades_List);
            interface1.Show_Grades(Grades_List);
            
            ArrayList<String> Grades_Char;
            Grades_Char = new ArrayList<>();
            
            Grades_Char.addAll(Access_Grades.ProcessGrade(Grades_List));
            interface1.Show_Grades(Grades_Char);
            
            System.out.println("\n --------------------------------");
            
            Access_Grades.disregardZero_Hundred(Grades_List);
            
            Grades_Char.removeAll(Grades_Char);
            Grades_Char.addAll(Access_Grades.ProcessGrade(Grades_List));
            
            interface1.Show_Grades(Grades_List);
            interface1.Show_Grades(Grades_Char);
            
        }
  }