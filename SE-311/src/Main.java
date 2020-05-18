// ATAHAN EKİCİ 
// MESUT ŞİMŞEK 
// ONAT KOCABAŞOĞLU
// Smart City Application

public class Main 
{
    public static void main(String[] args) 
{
    
        
    
    // Singleton proof //
        UI ui = UI.getInstance();
        UI ui2 = UI.getInstance(); // Only One Frame will be on display //
        UI ui3 = UI.getInstance();
        
        System.out.println(ui);
        System.out.println(ui2);
        System.out.println(ui3);//you should see frame0 in all the calls //
        // Singleton Proof //

}
}