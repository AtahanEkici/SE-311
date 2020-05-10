import javax.swing.*;  
import java.awt.event.*;  

public class UI implements ActionListener{  
    JTextField tf1,tf2,tf3;  
    JButton b1;  
    UI()
    {  
        @SuppressWarnings("LeakingThisInConstructor")
        
        JFrame f = new JFrame(); 
        
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        tf1=new JTextField();  
        tf1.setBounds(50,50,150,20); 
        
        tf2=new JTextField();  
        tf2.setBounds(50,100,150,20);  
        
        tf3=new JTextField();  
        tf3.setBounds(50,150,150,20);  
           
        b1=new JButton("OK");  
        b1.setBounds(100,200,50,50);
        
        b1.addActionListener(this);  
        
        f.add(tf1);f.add(tf2);f.add(tf3);f.add(b1);  
        f.setSize(300,300);  
        f.setLayout(null);  
        f.setVisible(true);  
    }         
    @Override
    public void actionPerformed(ActionEvent e) 
    {  
        if(e.getSource() == b1)
        {
            String mahalle = tf1.getText();
            String sokak = tf2.getText();
            String apartman = tf3.getText();
            
            Apartments apt = new Apartments(mahalle,sokak,apartman);
            Apartments.pushApartments(apt);
            Apartments.Print_Apartments();
        }
    }  
}  