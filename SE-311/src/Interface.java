// ATAHAN EKICI //
// MESUT SIMSEK //
// ONAT KOCABASOGLU //
// Smart City Application //

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
        /*
        CREATE FACTORY
        */
        sensorFactory sensorFac = new ConcreteSensorFactory();

        /*
        CREATE SENSORS VİA SENSORFACTORY.
        */
        Sensor pollution_sensor = sensorFac.createPollutionSensor(0);
        Sensor noise_sensor = sensorFac.createNoiseSensor(0);
        Sensor congestion_sensor = sensorFac.createCongestionSensor(0);
        Sensor temperature_sensor = sensorFac.createTemperatureSensor(0);
        
        
        pollution_sensor.sensorModel();
        pollution_sensor.sensorName();
        pollution_sensor.setSensorValue(0);
        
        noise_sensor.sensorModel();
        noise_sensor.sensorName();
        noise_sensor.setSensorValue(0);
        
        congestion_sensor.sensorModel();
        congestion_sensor.sensorName();
        congestion_sensor.setSensorValue(0);
        
        temperature_sensor.sensorModel();
        temperature_sensor.sensorName();
        temperature_sensor.setSensorValue(0);
        
        pollution_sensor.showSensorStats();
        temperature_sensor.showSensorStats();
        congestion_sensor.showSensorStats();
        noise_sensor.showSensorStats();  
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