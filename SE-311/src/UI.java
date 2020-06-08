// ATAHAN EKICI
// MESUT SIMSEK
// ONAT KOCABASOGLU
// Smart City Application

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.*;  
import java.awt.event.*;  
import javax.swing.border.LineBorder;
import java.util.Random;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
 

public final class UI extends JFrame implements ActionListener 
{    
    private static UI single_instance = null;
    
    UI()
    {  
       Construct_Main_Frame();
       Construct_Apartment_Builder();
       Construct_Pole_Builder();
       Construct_Sensor_Loop();
       Construct_Sensor_Selecter();
    }
    
    public static UI getInstance() // Singleton Pattern //
    {
        if(single_instance == null)
        {
            single_instance = new UI();
        }
            return single_instance;    
    }
    
    ArrayList <String> subs = new ArrayList <>();
    ArrayList <Sensor> construct = new ArrayList <>();
    
    JTextField tf1_apt,tf2_apt,tf3_apt,tf4_apt; // Apartment Text Areas //
    JTextField tf1_pol,tf2_pol,tf3_pol,tf4_pol;   // Pole Text Areas //
    
    JButton b_pol,b_apt,b_main_apt,b_main_pole,b_main_apt_show,b_main_pol_show,main_clear,show_sensors,reset_sensor,sensor_loop,menu_button;  // Buttons //
    
    JTextArea jta; // Kocaman Text Area //
    JTextArea jta_sen; //Sendika //
    JTextArea jt;
    
    JScrollPane jsp; // Kocaman Text Area'nın  Kocaman Scroll Bar'ı //
    JScrollPane jsp_sen;
    JScrollPane jsp_shsen;// paralel yapılanma //
    
    JCheckBox jcb_pole_temp,jcb_pole_pol,jcb_pole_con,jcb_pole_noise;    // Pole Sensors //
    JCheckBox jcb_temp_apt,jcb_pol_apt,jcb_con_apt,jcb_noise_apt; // Apartment Sensors //
    
    JMenuBar mb;

    Sensors sensorCollection = new Sensors();

    JFrame cpa = new JFrame("Pole Adder");
    JFrame cpb = new JFrame("Apartment Adder");
    JFrame main = new JFrame("Main Frame");
    JFrame svl = new JFrame("Sensor Value Loop");
    JFrame frame = new JFrame("Sensor Subscriber");
    
    DefaultListModel<String> defaultListModel = new DefaultListModel<>();
    JList<String> list = new JList<>();
    
    /**
     * @param i
     * @return 
     */

public static int CodeGenerator(int i) // Random Number Generator
    {
    Random random = new Random();
    int a = random.nextInt(i);
    return a;   
    }
    
    public void Construct_Main_Frame() // Man Frame //
    {
        
        main.setLayout(new BorderLayout());
        main.setResizable(false);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel tutucu = new JPanel();
        tutucu.setLayout(new FlowLayout(FlowLayout.LEADING));
        
        JPanel textArea = new JPanel();
        textArea.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        mb = new JMenuBar();
        main.setJMenuBar(mb);

        b_main_apt = new JButton("Add Apartment");
        b_main_apt.addActionListener(this);
        
        reset_sensor = new JButton("Reset Sensors");
        reset_sensor.addActionListener(this);
        
        main_clear = new JButton("Clear List");
        main_clear.addActionListener(this);
        
        b_main_apt_show = new JButton("Show Apartments");
        b_main_apt_show.addActionListener(this);
        
        show_sensors = new JButton("Show Sensors");
        show_sensors.addActionListener(this);
        
        sensor_loop = new JButton("Sensor Values");
        sensor_loop.addActionListener(this);
        
        b_main_pole = new JButton("Add Pole");
        b_main_pole.addActionListener(this);
        
        b_main_pol_show = new JButton("Show Poles");
        b_main_pol_show.addActionListener(this);
        
        menu_button = new JButton("GitHub");
        menu_button.setOpaque(true);
        menu_button.setFocusable(false);
        menu_button.addActionListener(this);
        
        mb.add(menu_button);
        
        tutucu.add(b_main_apt,BorderLayout.NORTH);
        tutucu.add(b_main_apt_show,BorderLayout.NORTH);
        tutucu.add(show_sensors,BorderLayout.NORTH);
        tutucu.add(reset_sensor,BorderLayout.NORTH);
        tutucu.add(sensor_loop,BorderLayout.NORTH);
        tutucu.add(b_main_pole,BorderLayout.NORTH);
        tutucu.add(b_main_pol_show,BorderLayout.NORTH);
        tutucu.add(main_clear,BorderLayout.NORTH);
        
        jsp = new JScrollPane();
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        jta = new JTextArea(45,70);
        jta.setBorder(new LineBorder(Color.BLACK));
        jta.setEditable(false);
        
        jsp.getViewport().setBackground(Color.WHITE);
        jsp.getViewport().add(jta);
        add(jsp);
                     
        textArea.add(jsp);
  
        main.add(textArea,BorderLayout.PAGE_END); // Text'leri tutan panelin JFrame'e iliştirilmesi //
        main.add(tutucu,BorderLayout.AFTER_LINE_ENDS);
        main.pack(); // Function that packs the frame and cuts the unnecessary lines //
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); // getting the current screen size //
        main.setLocation(dim.width/2-main.getSize().width/2, dim.height/2-main.getSize().height/2); // locate the frame in the center of the screen (initially of course user can define the location from there on out) //
        
        main.setVisible(true);  
    }
    
    public void authenticate()
    {
         for(int i = 0; i<subs.size();i++)
        {  
            for(int j = 0; j < Sensor.AllSensors.size(); j++)
            {                
                 if(Sensor.AllSensors.get(j).sensorName().replaceAll("\\s+","").equals(subs.get(i).replaceAll("\\s+","")))
                {
                    if(construct.contains(Sensor.AllSensors.get(j)) == false)
                    {
                        construct.add(Sensor.AllSensors.get(j));
                    }
                }
            }
        }
    }
    
void Construct_Sensor_Loop() // Printing All The Sensor values on a Window in a Loop //
    { 
        Timer timer;
    
        svl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        svl.setLayout(new BorderLayout());
        
        JPanel jp = new JPanel();
        jp.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        jsp_sen = new JScrollPane();
        jsp_sen.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       
        
        jta_sen = new JTextArea(40,75);
        jta_sen.setBorder(new LineBorder(Color.BLACK));
        jta_sen.setEditable(false);
        
        jsp_sen.getViewport().setBackground(Color.WHITE);
        jsp_sen.getViewport().add(jta_sen);
        
        
        add(jsp_sen);
                     
        jp.add(jsp_sen); 

         timer = new Timer(2000, (ActionEvent e) -> 
         {  
             authenticate();
             if(construct.isEmpty() == true)
             {
                 jta_sen.setText("");
             }
             else
             
          for(int i = 0; i < construct.size();i++)
        {
            int counter = i + 1;

             if(construct.get(i) instanceof Temperature_Sensor)
           {
               int randomNum = ThreadLocalRandom.current().nextInt(-10, 50 + 1);
               
              construct.get(i).setSensorValue(randomNum);
              
              if(construct.get(i).getSensorValue() < 0 )
              {
                   jta_sen.append(""+counter+")"+Sensor.AllSensors.get(i).sensorName()+" Value: "+construct.get(i).getSensorValue()+ "   !!WARNING!! \n ");
              }
              else
              {
                   jta_sen.append(""+counter+") "+construct.get(i).sensorName()+" Value: "+construct.get(i).getSensorValue()+ "\n");
              } 
           }
           
           else if(construct.get(i) instanceof Congestion_Sensor)
           {
                construct.get(i).setSensorValue(CodeGenerator(200));
              
              if(construct.get(i).getSensorValue() < 10 )
              {
                   jta_sen.append(""+counter+")"+construct.get(i).sensorName()+" Value: "+construct.get(i).getSensorValue()+ "   !!WARNING!! \n ");
              }
              else
              {
                   jta_sen.append(""+counter+") "+construct.get(i).sensorName()+"  Value: "+construct.get(i).getSensorValue()+ " \n");
              } 
           }
           
           else if(construct.get(i) instanceof Noise_Sensor)
           {
                construct.get(i).setSensorValue(CodeGenerator(100));
              
              if(construct.get(i).getSensorValue() > 85 )
              {
                  jta_sen.append(""+counter+")"+construct.get(i).sensorName()+" Value: "+construct.get(i).getSensorValue()+ "   !!WARNING!! \n ");
              }
              else
              {
                   jta_sen.append(""+counter+") "+construct.get(i).sensorName()+" Value: "+construct.get(i).getSensorValue()+ " \n");
              } 
           }
           
           else if(construct.get(i) instanceof Pollution_Sensor)
           {
                construct.get(i).setSensorValue(CodeGenerator(150));
              
              if(construct.get(i).getSensorValue() > 100 )
              {
                   jta_sen.append(""+counter+")"+construct.get(i).sensorName()+" Value: "+construct.get(i).getSensorValue()+ "     !!WARNING!! \n");
              }
              else
              {
                   jta_sen.append(""+counter+") "+construct.get(i).sensorName()+" Value: "+construct.get(i).getSensorValue()+ " \n ");
              } 
           }
           
           else
           {
               jta_sen.append(" \n Sensor Error \n");
           }
}
          jta_sen.append("\n");
        });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        
        svl.add(jp);
        svl.pack();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); // getting the current screen size // 
        svl.setLocation(dim.width/2-svl.getSize().width/2, dim.height/2-svl.getSize().height/2); // locate the frame in the center of the screen (initially of course user can define the location from there on out) //
        
        svl.setVisible(false);
    }
        
public void respin()
{
    defaultListModel.removeAllElements();
    jt.setText("");
    jt.setBackground(Color.white);
    
    for(int i = 0; i < Sensor.AllSensors.size();i++)
       {
           if(Sensor.AllSensors.get(i).attached_to_apt == true & Sensor.AllSensors.get(i).attached_to_pol == false)
           {
               String Temp = Sensor.AllSensors.get(i).sensorName()+" => " +Sensor.AllSensors.get(i).Attached+" (Apt.) ";
               defaultListModel.addElement(Temp);
           }
           else if(Sensor.AllSensors.get(i).attached_to_pol == true & Sensor.AllSensors.get(i).attached_to_apt == false)
           {
               String Temp = Sensor.AllSensors.get(i).sensorName()+" => " +Sensor.AllSensors.get(i).Attached+" (Pole) ";
               defaultListModel.addElement(Temp);
           }
           else
           {
               String Temp = Sensor.AllSensors.get(i).sensorName()+" => Not Attached";
               defaultListModel.addElement(Temp);
           }  
       }
list.setModel(defaultListModel);

SwingUtilities.updateComponentTreeUI(frame);

frame.invalidate();
frame.validate();
frame.repaint();
}


    public void Construct_Sensor_Selecter()
    {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        defaultListModel = new DefaultListModel<>();
        
        JPanel panel = new JPanel();
        
        jt = new JTextArea();
        panel.add(jt);
        
        jt.setEditable(false);

       JButton button = new JButton("Subscribe");
       button.addActionListener((ActionEvent e) -> 
       {
           String selected = list.getSelectedValue();
           selected = selected.trim();
           String temp = selected.split("=")[0];
           
           temp = temp.replaceAll("\\s+","");

           if(subs.contains(temp) == true)
           {
               jt.setBackground(Color.red);
               jt.setText(" Already Subscribed ");
           }
           
           else
           {
               subs.add(temp);
               jt.setBackground(Color.green);
               jt.setText(" Successfully Added to Subs "+temp+"");
               System.out.println(temp);
           }
       });
        
       frame.setPreferredSize(new Dimension(550,300));
       
       frame.add(new JScrollPane(list),BorderLayout.NORTH);
       frame.add(panel,BorderLayout.CENTER);
       frame.add(button,BorderLayout.PAGE_END);
         
       frame.pack();
 
       frame.setVisible(false);
    }
    
    public void Construct_Pole_Builder() // Frame that let's you add new poles //
    { 
        cpa.setResizable(false);
        cpa.setSize(450,350);  
        cpa.setLayout(null);
        cpa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
         jcb_pole_temp = new JCheckBox("Temp. Sensor");
         jcb_pole_pol = new JCheckBox("Poll. Sensor");
         jcb_pole_con = new JCheckBox("Cong. Sensor");
         jcb_pole_noise = new JCheckBox("Noise Sensor");
        
         jcb_pole_temp = new JCheckBox("Temp.Sensor");
         jcb_pole_temp.setLocation(325, 50);
         jcb_pole_temp.setOpaque(false);
         jcb_pole_temp.setSize(jcb_pole_temp.getPreferredSize());
         jcb_pole_temp.addActionListener(this);
         
         jcb_pole_pol = new JCheckBox("Poll.Sensor");
         jcb_pole_pol.setLocation(325, 75);
         jcb_pole_pol.setOpaque(false);
         jcb_pole_pol.setSize(jcb_pole_pol.getPreferredSize());
         jcb_pole_pol.addActionListener(this);
         
         jcb_pole_con = new JCheckBox("Cong.Sensor");
         jcb_pole_con.setLocation(325, 100);
         jcb_pole_con.setOpaque(false);
         jcb_pole_con.setSize(jcb_pole_con.getPreferredSize());
         jcb_pole_con.addActionListener(this);
         
         jcb_pole_noise = new JCheckBox("Noise Sensor");
         jcb_pole_noise.setLocation(325, 125);
         jcb_pole_noise.setOpaque(false);
         jcb_pole_noise.setSize(jcb_pole_noise.getPreferredSize());
         jcb_pole_noise.addActionListener(this);
        
        JPanel labeltutucu = new JPanel();
        labeltutucu.setSize(450,350);
        labeltutucu.setLayout(null);
        
        JLabel label = new JLabel("Mahalle:");
        label.setBounds(75, 50, 70, 20);
        
        JLabel label2 = new JLabel("Sokak:");
        label2.setBounds(85, 100, 70, 20);
        
        JLabel label3 = new JLabel("Direk:");
        label3.setBounds(90, 150, 70, 20);      
        
        tf1_pol = new JTextField();  
        tf1_pol.setBounds(125,50,150,20); 
        
        tf2_pol = new JTextField();  
        tf2_pol.setBounds(125,100,150,20);  
        
        tf3_pol = new JTextField();  
        tf3_pol.setBounds(125,150,150,20);  
        
        tf4_pol = new JTextField("Lütfen ilgili değerleri girin.");  
        tf4_pol.setBounds(125,275,150,20);
        tf4_pol.setEditable(false);
           
        b_pol = new JButton();  
        b_pol.setText("ok");
        b_pol.setBounds(175,200,50,50); 
        
        b_pol.addActionListener(this);  
        
        cpa.add(tf1_pol); // text field attaching with JFrame//
        cpa.add(tf2_pol); // text field attaching with JFrame//
        cpa.add(tf3_pol); // text field attaching with JFrame//
        cpa.add(tf4_pol); // text field attaching with JFrame//
        
        cpa.add(b_pol); // button attached to JFrame //
        
        labeltutucu.add(label);
        labeltutucu.add(label2);
        labeltutucu.add(label3);
        
        labeltutucu.add(jcb_pole_temp);
        labeltutucu.add(jcb_pole_pol);
        labeltutucu.add(jcb_pole_con);
        labeltutucu.add(jcb_pole_noise);
        
        cpa.add(labeltutucu);
        cpa.setVisible(false);
    }
    
    public void Construct_Apartment_Builder() // Frame that let's you build new Apartments //
    {  
        
        cpb.setResizable(false);
        cpb.setSize(450,350);  
        cpb.setLayout(null);
        cpb.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
         jcb_temp_apt = new JCheckBox("Temp.Sensor");
         jcb_temp_apt.setLocation(325, 50);
         jcb_temp_apt.setOpaque(false);
         jcb_temp_apt.setSize(jcb_temp_apt.getPreferredSize());
         jcb_temp_apt.addActionListener(this);
         
         jcb_pol_apt = new JCheckBox("Poll.Sensor");
         jcb_pol_apt.setLocation(325, 75);
         jcb_pol_apt.setOpaque(false);
         jcb_pol_apt.setSize(jcb_pol_apt.getPreferredSize());
         jcb_pol_apt.addActionListener(this);
         
         
         jcb_con_apt = new JCheckBox("Cong.Sensor");
         jcb_con_apt.setLocation(325, 100);
         jcb_con_apt.setOpaque(false);
         jcb_con_apt.setSize(jcb_con_apt.getPreferredSize());
         jcb_con_apt.addActionListener(this);
         
         jcb_noise_apt = new JCheckBox("Noise Sensor");
         jcb_noise_apt.setLocation(325, 125);
         jcb_noise_apt.setOpaque(false);
         jcb_noise_apt.setSize(jcb_noise_apt.getPreferredSize());
         jcb_noise_apt.addActionListener(this);
        
        JPanel labeltutucu = new JPanel();
        labeltutucu.setSize(450,350);
        labeltutucu.setLayout(null);
        
        JLabel label = new JLabel("Mahalle:");
        label.setBounds(75, 50, 70, 20);
        
        JLabel label2 = new JLabel("Sokak:");
        label2.setBounds(85, 100, 70, 20);
        
        JLabel label3 = new JLabel("Apartman:");
        label3.setBounds(65, 150, 70, 20);        
        
        tf1_apt = new JTextField();  
        tf1_apt.setBounds(125,50,150,20); 
        
        tf2_apt = new JTextField();  
        tf2_apt.setBounds(125,100,150,20);  
        
        tf3_apt = new JTextField();  
        tf3_apt.setBounds(125,150,150,20);  
        
        tf4_apt = new JTextField("Lütfen ilgili değerleri girin.");  
        tf4_apt.setBounds(125,275,150,20);
        tf4_apt.setEditable(false);
           
        b_apt = new JButton();  
        b_apt.setText("ok");
        b_apt.setBounds(175,200,50,50);
        
        b_apt.addActionListener(this);
        
        
        cpb.add(tf1_apt); // text field attaching with JFrame//
        cpb.add(tf2_apt); // text field attaching with JFrame//
        cpb.add(tf3_apt); // text field attaching with JFrame//
        cpb.add(tf4_apt); // text field attaching with JFrame//
        cpb.add(b_apt); // buton attached to JFrame //
        
        labeltutucu.add(label);
        labeltutucu.add(label2);
        labeltutucu.add(label3);
        
        labeltutucu.add(jcb_temp_apt);
        labeltutucu.add(jcb_pol_apt);
        labeltutucu.add(jcb_con_apt);
        labeltutucu.add(jcb_noise_apt);
        
        cpb.add(labeltutucu);
        cpb.setVisible(false);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) // Action Listener bir değişim algıladığında execute edilecek komut dizini  başlangıcı //
    {           
        if(e.getSource() == b_main_apt) // Apartman ekleye basıldığında ilgili Frame'i çağırır //
        {
            cpb.setVisible(true);
            tf4_apt.setText("");
            tf4_apt.setBackground(Color.white);
        }
        else if(e.getSource() == menu_button)
        {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE))
            {
                try 
                {
                    Desktop.getDesktop().browse(new URI("https://github.com/AtahanEkici/SE-311"));
                } catch (URISyntaxException | IOException ex) 
                {
                    jta.append("\n ERROR: "+ex+" => Not enough Permissions are granted \n");
                }
}
        }
        
        else if(e.getSource() == b_main_pole) // Direk ekleye basıldığında ilgili Frame'i çağırır //
        {
            tf4_pol.setText("");
            tf4_pol.setBackground(Color.white);
            cpa.setVisible(true);
        }
        
        else if(e.getSource() == main_clear)  // Text Area'yı sıfırlama butonu //
        {
            jta.setText("");
        }
        
        else if(e.getSource() == reset_sensor)  // Sensör Resetleme Butonu //
        {  
            if(Sensor.AllSensors.isEmpty() == true)
            {
                jta.append(" \n Sensors can't be reset because there aren't any ! \n ");
            }
            
            else
            {
class ResetVisitor implements Visitor
{
    @Override
    public void Visit(Sensor sensor) 
    {
       sensor.setSensorValue(0);
       jta.append(" ID:"+sensor.SensorID+"  "+sensor.sensorName()+" is resetted => new sensorValue is : "+sensor.getSensorValue()+" \n ");
    }
    
}
            sensorCollection.Accept(new ResetVisitor());
}
            jta.append("\n");
}
        else if(e.getSource() == sensor_loop)
        {
            svl.setVisible(true);
        }
        
        else if(e.getSource() == show_sensors) // Sensörleri Göster butonu //
        {
            respin();
            frame.setVisible(true);
            
            /*
            if(Sensor.AllSensors.isEmpty() == true) // Boşsa hata mesajı döndürür //
            {
                jta.append("\n Henüz Sensör eklenmemiş \n");
            }
              
            else // Sensörler boş değilse göster //
        {
            jta.append("\n Sensors: \n");
            
                for(int i = 0;i <Sensor.AllSensors.size();i++)
            {
                int counter = i + 1;
                
                if(Sensor.AllSensors.get(i).attached_to_apt != null)
                {
                    jta.append(" " +counter+") ID:"+Sensor.AllSensors.get(i).SensorID+" ("+Sensor.AllSensors.get(i).sensorName()+": attached to "+Sensor.AllSensors.get(i).attached_to_apt+" ");
                }
                
                else if(Sensor.AllSensors.get(i).attached_to_pol != null)
                {
                    jta.append(" " +counter+") ID:"+Sensor.AllSensors.get(i).SensorID+" ("+Sensor.AllSensors.get(i).sensorName()+": attached to "+Sensor.AllSensors.get(i).attached_to_pol+" ");
                }
                
                else
                {
                    jta.append(" This Sensor ID:"+Sensor.AllSensors.get(i).SensorID+" ("+Sensor.AllSensors.get(i).sensorName()+" appears to be attached to no other pole or apartment ");
                }
                jta.append("\n");
            }
                jta.append("\n");
        }
*/
        }
        
        else if(e.getSource() == b_main_apt_show) // Apartmanları Göster Butonu //
        {
            String temp;
            
            if(Apartments.list.isEmpty() == true)
            {
                jta.append("\n Currently nothing is added to Apartments \n");
            }
            else
            {
            jta.append("\n Apartments: \n");
            
            for(int i = 0;i < Apartments.list.size();i++)
           {
               int counter = i+1;
               temp = "\n "+counter+") "+Apartments.list.get(i).toString()+" ";
               jta.append(temp);
           }
           temp = "\n";
           jta.append(temp);
            } 
        }      
        
        else if(e.getSource() == b_main_pol_show)// Direkleri Göster Butonu //
        {
             String temp;
             jta.append(" \n Poles: \n");
             
           if(Pole.Pole_list.isEmpty() == true) // liste boşsa hata mesajı yazdır //
            {
                jta.append("\n Currently nothing is added to Poles\n");
            }
           else
               // listede değer varsa ilgili değeri yazdır //   
           for(int i = 0;i < Pole.Pole_list.size();i++)
           {
               
               int counter = i+1;
               temp = "\n"+counter+") "+Pole.Pole_list.get(i).toString()+" ";
               jta.append(temp);
           }
           jta.append(" \n ");
        }
        
        else if(e.getSource() == b_apt) // Apartman Ekle Butonu için Action Listener //
        {       
             if(tf1_apt.getText().isEmpty() == true | tf2_apt.getText().isEmpty() == true | tf3_apt.getText().isEmpty() == true)// Bütün Textler Dolu mu diye kontrol eden mekanizma //
            {
                tf4_apt.setBackground(Color.red);
                tf4_apt.setBounds(125,275,200,20);
                tf4_apt.setText("Lütfen bütün boşlukları doldurunuz.");
            }
                
             else  // Doğruysa veriyi ekleyen mekanizma //
        {
                 
            String mahalle = tf1_apt.getText();
            String sokak = tf2_apt.getText();
            String apartman = tf3_apt.getText();
                 
             if(Apartments.Apt_IsExists(apartman) == true)
             {
                tf4_apt.setBackground(Color.red);
                tf4_apt.setBounds(125,275,200,20);
                tf4_apt.setText(" Apartment is already exists ");
             }
             else
             {
                 
         sensorFactory sensorFac = new ConcreteSensorFactory();         
                  
            tf4_apt.setBackground(Color.green);
            tf4_apt.setBounds(125,275,110,20);
            tf4_apt.setText("Başarıyla eklendi");
            
            
            Apartments yeni_apt = new Apartments(mahalle,sokak,apartman);
            
            String temp = " \n Yeni Apartman Eklendi ADI: "+apartman+" \n ";
            jta.append(temp);
             
            if(jcb_temp_apt.isSelected() == true) // İlgili Apartmana yeni temp sensör eklenip eklenmediğini kontrol eder //
            {
               Sensor tempSensor = sensorFac.createTemperatureSensor(CodeGenerator(100));
               //sensorCollection.add(tempSensor);
               tempSensor.Attach(yeni_apt);
               
               jta.append(" \n " +tempSensor.sensorName()+ " is installed on " +tempSensor.Attached+ " \n ");
               
            }
 
            if(jcb_con_apt.isSelected() == true) // İlgili Apartmana yeni cong sensör eklenip eklenmediğini kontrol eder //
            {
                Sensor congSensor = sensorFac.createCongestionSensor(CodeGenerator(100));
                //sensorCollection.add(congSensor);
                congSensor.Attach(yeni_apt);
                
                jta.append(" \n " +congSensor.sensorName()+ " is installed on " +congSensor.Attached+ " \n ");
            }
            
            if(jcb_pol_apt.isSelected() == true) // İlgili Apartmana yeni pollution sensör eklenip eklenmediğini kontrol eder //
            {
                Sensor polSensor = sensorFac.createPollutionSensor(CodeGenerator(100));
                //sensorCollection.add(polSensor);
                polSensor.Attach(yeni_apt);
                
                jta.append(" \n " +polSensor.sensorName()+ " is installed on " +polSensor.Attached+ " \n ");
            }
            
            if(jcb_noise_apt.isSelected() == true) // İlgili Apartmana yeni noise sensör eklenip eklenmediğini kontrol eder //
            {
                Sensor noiseSensor = sensorFac.createNoiseSensor(CodeGenerator(100));
                //sensorCollection.add(noiseSensor);
                noiseSensor.Attach(yeni_apt);
                
                jta.append(" \n " +noiseSensor.sensorName()+ " is installed on " +noiseSensor.Attached+ " \n ");
            }
        } 
    respin();            
}
}
        
        else if(e.getSource() == b_pol) // Direk Ekleden sonra açılan frame'deki "ok" için Action Listener kısmı //
        {
            if(tf1_pol.getText().isEmpty() == true | tf2_pol.getText().isEmpty() == true | tf3_pol.getText().isEmpty() == true) // Bütün Textler Dolu mu diye kontrol eden mekanizma //
            {
                tf4_pol.setBackground(Color.red);
                tf4_pol.setBounds(125,275,200,20);
                tf4_pol.setText("Lütfen bütün boşlukları doldurunuz.");
            }
                
            else // Doğruysa veriyi ekleyen mekanizma //
        {  
             
            String mahalle = tf1_pol.getText();
            String sokak = tf1_pol.getText();
            String direk = tf1_pol.getText();
                
                
                  if(Pole.Pol_IsExists(direk) == true)
            {
                tf4_pol.setBackground(Color.red);
                tf4_pol.setBounds(125,275,200,20);
                tf4_pol.setText(" Pole is Already exist ");
            }
            else
            {
            sensorFactory sensorFac = new ConcreteSensorFactory();
        
            tf4_pol.setBackground(Color.green);
            tf4_pol.setBounds(125,275,110,20);
            tf4_pol.setText("Başarıyla eklendi");
          
            Pole yeni_direk = new Pole(mahalle,sokak,direk); 
            jta.append(" \n Yeni Direk Eklendi \n ");

            if(jcb_pole_temp.isSelected() == true) // İlgili direğe yeni temperature sensör eklenip eklenmediğini kontrol eder //
            {
               Sensor tempSensor = sensorFac.createTemperatureSensor(CodeGenerator(100));
               //sensorCollection.add(tempSensor);
               tempSensor.Attach_Pole(yeni_direk);
               
               jta.append(" \n " +tempSensor.sensorName()+ " is installed on " +tempSensor.Attached+ " \n ");
            }
 
            if(jcb_pole_pol.isSelected() == true) // İlgili direğe yeni pollution sensör eklenip eklenmediğini kontrol eder //
            {
                Sensor polSensor = sensorFac.createPollutionSensor(CodeGenerator(100));
                //sensorCollection.add(polSensor);
                polSensor.Attach_Pole(yeni_direk);
                
                jta.append(" \n " +polSensor.sensorName()+ " is installed on " +polSensor.Attached+ " \n ");
            }
            
            if(jcb_pole_con.isSelected() == true) // İlgili direğe yeni congestion sensör eklenip eklenmediğini kontrol eder //
            {
                Sensor congSensor = sensorFac.createCongestionSensor(CodeGenerator(100));
                //sensorCollection.add(congSensor);
                congSensor.Attach_Pole(yeni_direk);             
                
                jta.append(" \n " +congSensor.sensorName()+ " is installed on " +congSensor.Attached+ " \n ");
            }
            
            if(jcb_pole_noise.isSelected() == true) // İlgili direğe yeni noise sensör eklenip eklenmediğini kontrol eder //
            {
                Sensor noiseSensor = sensorFac.createNoiseSensor(CodeGenerator(100));
                //sensorCollection.add(noiseSensor);
                noiseSensor.Attach_Pole(yeni_direk);
                
                jta.append(" \n " +noiseSensor.sensorName()+ " is installed on "+noiseSensor.Attached+" \n ");
            }
        }
                  respin();
        }
    } 
    }
}