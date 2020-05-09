import java.util.ArrayList;
import java.util.Random;

abstract class Sensor
{
    public abstract int sensorID();
    public abstract String sensorName();
    public abstract String sensorModel();
    public abstract boolean notified();



    public abstract void setSensorValue(int value);

    public abstract int getSensorValue();

    protected ArrayList<Apartments> _subscribedApartments = new ArrayList<>();


    public void Attach(Apartments apartmen){
        _subscribedApartments.add(apartmen);
    }

    public void Detach(Apartments apartment){

        for(int i = 0;i<= _subscribedApartments.size();i++ ){
           if(apartment.getName().equals(_subscribedApartments.get(i).getName())) {
               _subscribedApartments.remove(apartment);
           }
        }


    }


    public void Notify() {
        _subscribedApartments.forEach((subscribedApartment) -> {
            subscribedApartment.Update(this);
        });
    }


    //public void

    public Sensor()
    {

    }

    void showSensorStats()
    {
        System.out.println("---------------------------");
        System.out.println("Sensor ID: " + sensorID());
        System.out.println("Sensor Name: " + sensorName());
        System.out.println("Sensor Model: " + sensorModel());
        System.out.println("Is it notified? " + ":" + notified());
        System.out.println("---------------------------");
    }
}

class Pollution_Sensor extends Sensor
{
    private int _pollution;
    private boolean pollutionNoticed;


    public Pollution_Sensor()
    {

    }

    public boolean isPollutionNoticed() {
        return pollutionNoticed;
    }

    public void setPollutionNoticed(boolean pollutionNoticed) {
        this.pollutionNoticed = pollutionNoticed;


    }

    public int getPollution() {
        return _pollution;
    }

    public void setPollution(int pollution) {
        _pollution = pollution;
        Notify();
    }

    @Override
    public int sensorID() {
        return 0;
    }

    @Override
    public String sensorName() {
        return "Pollution Sensor";
    }

    @Override
    public String sensorModel() {
        return "KF1500";
    }

    @Override
    public boolean notified() {
        return false;
    }

    @Override
    public void setSensorValue(int value) {
        setPollution(value);
    }

    @Override
    public int getSensorValue() {
        return _pollution;
    }

    public Pollution_Sensor createPollutionSensor()
    {
        return new Pollution_Sensor();
    }

    public void calculatePollution(int newPollution)
    {
        Random calc = new Random();
        newPollution = calc.nextInt(200);
        if(newPollution > 100)
        {
            newPollution = _pollution;
            setPollution(_pollution);
        }
        System.out.println("The pollution is: " + getPollution() + "WARNING!" + notified());
    }
}

class Temperature_Sensor extends Sensor
{

    int _celcius;
/*
    int Kelvin;
    int Fahrenheit;
*/
    @Override
    public int sensorID() {
        return 1;
    }

    @Override
    public String sensorName() {
        return "Temp Sensor";
    }

    @Override
    public String sensorModel() {
        return "KF2500";
    }

    @Override
    public boolean notified() {
        return false;
    }

    public void setSensorValue(int value) {
        setCelcius(value);
    }

    @Override
    public int getSensorValue() {
        return _celcius;
    }

    public Temperature_Sensor createTemperatureSensor()
    {
        return new Temperature_Sensor();
    }

    public void setCelcius(int celcius){
        _celcius = celcius;
        Notify();
    }
}

class Congestion_Sensor extends Sensor
{
    int _congestion;

    @Override
    public int sensorID() {
        return 2;
    }

    @Override
    public String sensorName() {
        return "congestion";
    }

    @Override
    public String sensorModel() {
        return "KF3500";
    }

    @Override
    public boolean notified() {
        return false;
    }

    @Override
    public void setSensorValue(int value) {
        set_pollution(value);
    }

    @Override
    public int getSensorValue() {
        return _congestion;
    }

    public Congestion_Sensor createCongestionSensor()
    {
        return new Congestion_Sensor();
    }


    public void set_pollution(int pollution) {
        _congestion = pollution;
        Notify();
    }
}

class Noise_Sensor extends Sensor
{
    int _volume;

    @Override
    public int sensorID() {
        return 3;
    }

    @Override
    public String sensorName() {
        return "noise sensor";
    }

    @Override
    public String sensorModel() {
        return "KF5500";
    }

    @Override
    public boolean notified() {
        return false;
    }

    @Override
    public void setSensorValue(int value) {
        setVolume(value);
    }

    @Override
    public int getSensorValue() {
        return _volume;
    }

    public Noise_Sensor createNoiseSensor()
    {
        return new Noise_Sensor();
    }


    public void setVolume(int vol){
        _volume = vol;
        Notify();
    }
}
