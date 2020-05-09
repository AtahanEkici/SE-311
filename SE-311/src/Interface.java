interface UserInterface
{
    public void showSensor();
    public void showStreet();
    public void showNeighbour();
    public void showApartment();
}
class Interface1 implements UserInterface 
{
    @Override
    public void showSensor() 
    {
        Sensor s1 = new Pollution_Sensor();
        Sensor s2 = new Noise_Sensor();
        Sensor s3 = new Congestion_Sensor();
        Sensor s4 = new Temperature_Sensor();
        
        s1.sensorModel();
        s1.sensorName();
        s1.setSensorValue(0);
        
        s2.sensorModel();
        s2.sensorName();
        s2.setSensorValue(0);
        
        s3.sensorModel();
        s3.sensorName();
        s3.setSensorValue(0);
        
        s4.sensorModel();
        s4.sensorName();
        s4.setSensorValue(0);
        
        s1.showSensorStats();
        s4.showSensorStats();
        s3.showSensorStats();
        s2.showSensorStats();  
    }

    @Override
    public void showStreet()
    {
        Street street = new Street("Test Street", "Test Neighbour")
        {
            @Override
            public String toString() {
                return super.toString();
            }
        };
    }

    @Override
    public void showNeighbour() {
        Neighborhood neighborhood = new Neighborhood("Test Neighbour") {
            @Override
            public String toString() {
                return super.toString();
            }
        };
    }

    @Override
    public void showApartment() {
        Apartments apt1 = new Apartments("Test Apartment", "Test Street", "Test Neighbour"){
            @Override
            public String toString() {
                return super.toString();
            }
        };
    }
}
    //Burada bir concrete pattern bulunmaktadır.
    class InterfacePanel
    {
        private final UserInterface interface1;
      
        public InterfacePanel()
        {
            interface1 = new Interface1();
        }
        public void showInterface1()
        {
            interface1.showSensor();
            interface1.showApartment();
            interface1.showNeighbour();  
            interface1.showStreet();
        }
    }
