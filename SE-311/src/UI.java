 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.*;  
import java.awt.event.*;  
import java.util.Random;
import javax.swing.border.LineBorder;

public final class UI extends JFrame implements ActionListener 
{    
    JTextField tf1_apt,tf2_apt,tf3_apt,tf4_apt; // Apartment Text Areas //
    JTextField tf1_pol,tf2_pol,tf3_pol,tf4_pol;   // Pole Text Areas //
    
    JButton b_pol,b_apt,b_main_apt,b_main_pole,b_main_apt_show,b_main_pol_show,main_clear,show_sensors,reset_sensor;  // Buttons //
    
    JTextArea jta; // Kocaman Text area //
    
    JScrollPane jsp; // Kocaman Text Area'nın  Kocaman Scroll Bar'ı //
    
    JCheckBox jcb_pole_temp,jcb_pole_pol,jcb_pole_con,jcb_pole_noise;    // Pole Sensors //
    JCheckBox jcb_temp_apt,jcb_pol_apt,jcb_con_apt,jcb_noise_apt; // Apartment Sensors //
    
    Sensors sensorCollection = new Sensors();
    
    //Boolean pole_temp,pole_pol,pole_con,pole_noise = false;
    //Boolean apt_temp,apt_pol,apt_con,apt_noise = false;
    
    UI()
    {   
    }
    
    /**
     */
    public static final void ShowUI()
    {
       UI ui = new UI();
       ui.Construct_Main_Frame();
    }
    
public static int CodeGenerator(int i) 
    {
    Random random = new Random();
    int a = random.nextInt(i);
    return a;   
    }
    
    public void Construct_Main_Frame()
    {
        JFrame f = new JFrame("Main Frame");
        //f.setSize(640, 480);
        f.setLayout(new BorderLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel tutucu = new JPanel();
        tutucu.setLayout(new FlowLayout(FlowLayout.LEADING));
        
        JPanel textArea = new JPanel();
        textArea.setLayout(new FlowLayout(FlowLayout.CENTER));
        
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
        
        b_main_pole = new JButton("Add Pole");
        b_main_pole.addActionListener(this);
        
        b_main_pol_show = new JButton("Show Poles");
        b_main_pol_show.addActionListener(this);
        
        tutucu.add(b_main_apt,BorderLayout.NORTH);
        tutucu.add(b_main_apt_show,BorderLayout.NORTH);
        tutucu.add(show_sensors,BorderLayout.NORTH);
        tutucu.add(reset_sensor,BorderLayout.NORTH);
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
                    
        //repaint();
        
        textArea.add(jsp); 
        
          // Text'leri tutan panelin JFrame'e iliştirilmesi //
        f.add(textArea,BorderLayout.PAGE_END);
        f.add(tutucu,BorderLayout.AFTER_LINE_ENDS);
        f.pack();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); // getting the current screen size //
        
        f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2); // render first frame in the center of the screen //
        
        f.setVisible(true);  
    }
    
    public void Construct_Pole_Builder()
    {
        JFrame f = new JFrame("Pole Adder"); 
        f.setResizable(false);
        f.setSize(450,350);  
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
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
        
        f.add(tf1_pol); // text field attaching with JFrame//
        f.add(tf2_pol); // text field attaching with JFrame//
        f.add(tf3_pol); // text field attaching with JFrame//
        f.add(tf4_pol); // text field attaching with JFrame//
        f.add(b_pol); // buton attached to JFrame //
        
        labeltutucu.add(label);
        labeltutucu.add(label2);
        labeltutucu.add(label3);
        
        labeltutucu.add(jcb_pole_temp);
        labeltutucu.add(jcb_pole_pol);
        labeltutucu.add(jcb_pole_con);
        labeltutucu.add(jcb_pole_noise);
        
        f.add(labeltutucu);

        f.setVisible(true);
    }
    
    public void Construct_Apartment_Builder()
    {  
        JFrame f = new JFrame("Apartment Adder");
        f.setResizable(false);
        f.setSize(450,350);  
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
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
        
        
        f.add(tf1_apt); // text field attaching with JFrame//
        f.add(tf2_apt); // text field attaching with JFrame//
        f.add(tf3_apt); // text field attaching with JFrame//
        f.add(tf4_apt); // text field attaching with JFrame//
        f.add(b_apt); // buton attached to JFrame //
        
        labeltutucu.add(label);
        labeltutucu.add(label2);
        labeltutucu.add(label3);
        
        labeltutucu.add(jcb_temp_apt);
        labeltutucu.add(jcb_pol_apt);
        labeltutucu.add(jcb_con_apt);
        labeltutucu.add(jcb_noise_apt);
        
        
        f.add(labeltutucu);
        f.setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) // Action Listener bir değişim algıladığında execute edilecek komut dizini  başlangıcı //
    {
            
        if(e.getSource() == b_main_apt) // Apartman ekleye basıldığında ilgili Frame'i çağırır //
        {
            Construct_Apartment_Builder(); 
        }
        
        else if(e.getSource() == b_main_pole) // Direk ekleye basıldığında ilgili Frame'i çağırır //
        {
            Construct_Pole_Builder(); 
        }
        
        else if(e.getSource() == main_clear)  // Text Area'yı sıfırlama butonu //
        {
            jta.setText("");
        }
        
        else if(e.getSource() == reset_sensor)  // Sensör Resetleme Butonu //
        {  
            
  class ResetVisitor implements Visitor // Bütün çabalarım asılsız kalınca bir Override da buraya ekledim // 
{
    @Override
    public void Visit(Sensor sensor) 
    {
       sensor.setSensorValue(0);
       jta.append("\n "+sensor.sensorName()+" is reset. \n ");
       jta.append(" new sensorValue is : " + sensor.getSensorValue()+"\n");    
    }
  }
        sensorCollection.Accept(new ResetVisitor()); 
        }
        
        else if(e.getSource() == show_sensors) // Sensörleri Göster butonu //
        {
            if(Sensors._sensors.isEmpty() == true)
            {
                jta.append("\n Henüz Sensör eklenmemiş \n");
            }
              
            else // Sensörler boş değilse göster //
        {
            jta.append("\n Sensors: \n");
            
                for(int i = 0;i <Sensors._sensors.size();i++)
            {
                int counter = i + 1;
                jta.append("\n" +counter+" \"\n\" ) "+Sensors._sensors.get(i));
            }
        }
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
           temp = "\n";
           jta.append(temp);
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
                 
                 sensorFactory sensorFac = new ConcreteSensorFactory();
                 BuildSensor sensorBuilder = new BuildSensor();
                 
        Sensor tempSensor = sensorFac.createTemperatureSensor(CodeGenerator(100));
        Sensor polSensor = sensorFac.createPollutionSensor(CodeGenerator(100));
        Sensor noiseSensor = sensorFac.createNoiseSensor(CodeGenerator(100));
        Sensor congSensor = sensorFac.createCongestionSensor(CodeGenerator(100));
                 
            tf4_apt.setBackground(Color.green);
            tf4_apt.setBounds(125,275,110,20);
            tf4_apt.setText("Başarıyla eklendi");
            
            String mahalle = tf1_apt.getText();
            String sokak = tf2_apt.getText();
            String apartman = tf3_apt.getText();
            
            Apartments yeni_apt = new Apartments(mahalle,sokak,apartman);
            
            String temp = "Yeni Apartman Eklendi";
            jta.append(temp);
             
            if(jcb_temp_apt.isSelected() == true) // İlgili Apartmana yeni temp sensör eklenip eklenmediğini kontrol eder //
            {
               tempSensor = sensorFac.createTemperatureSensor(0);
               tempSensor.Attach(yeni_apt);
               //tempSensor.setSensorValue(CodeGenerator(100));
              // tempSensor.getSensorValue();
               
               jta.append("\n"  +tempSensor.sensorName()+ " is installed \n");
               
                //int temp2 = tempSensor.getSensorValue();
                //jta.append("\n"+Integer.toString(temp2)+"\n");
            }
 
            if(jcb_con_apt.isSelected() == true) // İlgili Apartmana yeni cong sensör eklenip eklenmediğini kontrol eder //
            {
                congSensor.Attach(yeni_apt);
                congSensor.setSensorValue(CodeGenerator(100));
                
                jta.append("\n"  +congSensor.sensorName()+ " is installed \n");
                
                //int temp2 = congSensor.getSensorValue();
               // jta.append("\n"+Integer.toString(temp2)+"\n");
            }
            
            if(jcb_pol_apt.isSelected() == true) // İlgili Apartmana yeni pollution sensör eklenip eklenmediğini kontrol eder //
            {
                polSensor.Attach(yeni_apt);
                polSensor.setSensorValue(CodeGenerator(100));
                //polSensor.getSensorValue();
                
                jta.append("\n"  +polSensor.sensorName()+ " is installed \n");
                
                //int temp2 = polSensor.getSensorValue();
                //jta.append("\n"+Integer.toString(temp2)+"\n");
            }
            
            if(jcb_noise_apt.isSelected() == true) // İlgili Apartmana yeni noise sensör eklenip eklenmediğini kontrol eder //
            {
                noiseSensor.Attach(yeni_apt);
                noiseSensor.setSensorValue(CodeGenerator(100));
                //noiseSensor.getSensorValue();
                
                jta.append(" \n "  +noiseSensor.sensorName()+ " is installed \n ");
                
                //int temp2 = noiseSensor.getSensorValue();
                //jta.append("\n"+Integer.toString(temp2)+"\n");
            }
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
                
        sensorFactory sensorFac = new ConcreteSensorFactory();
                 
        Sensor tempSensor = sensorFac.createTemperatureSensor(CodeGenerator(100));
        sensorCollection.add(tempSensor);
         
        Sensor polSensor = sensorFac.createPollutionSensor(CodeGenerator(100));
        sensorCollection.add(polSensor);
         
        Sensor noiseSensor = sensorFac.createNoiseSensor(CodeGenerator(100));
        sensorCollection.add(noiseSensor);
         
        Sensor congSensor = sensorFac.createCongestionSensor(CodeGenerator(100));
        sensorCollection.add(congSensor);
        
            tf4_pol.setBackground(Color.green);
            tf4_pol.setBounds(125,275,110,20);
            tf4_pol.setText("Başarıyla eklendi");
            
            String mahalle = tf1_pol.getText();
            String sokak = tf1_pol.getText();
            String direk = tf1_pol.getText();
            
            Pole yeni_direk = new Pole(mahalle,sokak,direk);
            
            String temp = "Yeni Direk Eklendi";
            jta.append(temp);
            
            if(jcb_pole_temp.isSelected() == true) // İlgili direğe yeni temperature sensör eklenip eklenmediğini kontrol eder //
            {
               tempSensor.Attach_Pole(yeni_direk);
               tempSensor.setSensorValue(CodeGenerator(100));
               //tempSensor.getSensorValue();
               
               jta.append(" \n "  +tempSensor.sensorName()+ " is installed \n ");
               
                //int temp2 = tempSensor.getSensorValue();
                //jta.append("\n"+Integer.toString(temp2)+"\n");
            }
 
            if(jcb_pole_pol.isSelected() == true)
            {
                congSensor.Attach_Pole(yeni_direk);
                congSensor.setSensorValue(CodeGenerator(100));
                
                jta.append(" \n "  +congSensor.sensorName()+ " is installed \n ");
                
                //int temp2 = congSensor.getSensorValue();
                //jta.append("\n"+Integer.toString(temp2)+"\n");
            }
            
            if(jcb_pole_con.isSelected() == true)
            {
                polSensor.Attach_Pole(yeni_direk);
                polSensor.setSensorValue(CodeGenerator(100));
               // polSensor.getSensorValue();
                
                jta.append(" \n "  +polSensor.sensorName()+ " is installed \n ");
                
                //int temp2 = polSensor.getSensorValue();
                //jta.append("\n"+Integer.toString(temp2)+"\n");
            }
            
            if(jcb_pole_noise.isSelected() == true)
            {
                noiseSensor.Attach_Pole(yeni_direk);
                noiseSensor.setSensorValue(CodeGenerator(100));
                //noiseSensor.getSensorValue();
                
                jta.append(" \n "  +noiseSensor.sensorName()+ " is installed \n ");
                
                //int temp2 = noiseSensor.getSensorValue();
                //jta.append("\n"+Integer.toString(temp2)+"\n");
            }
        }    
        }
    } 
}                 