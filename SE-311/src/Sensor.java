import java.util.ArrayList;
import java.util.Random;

interface AbstractAggregate 
{
	public AbstractIterator CreateIterator();
	public void add(Apartments it); 		// Not needed for iteration.
	public int getCount (); // Needed for iteration.
	public Apartments get(int idx); // Needed for iteration.
        public ArrayList<Apartments> getItems();
};

//This is the concrete Aggregate.
//			Collection


class Collection implements AbstractAggregate 
{
	private	 ArrayList<Apartments> _items = new ArrayList<>();
        
        @Override
	public	ApartmentIterator CreateIterator() 
        {
		return new ApartmentIterator(this);
	}
        
        @Override
	public int getCount () {return _items.size(); }
        
        @Override
	public void add(Apartments item) {_items.add(item);}
        
        @Override
	public Apartments get(int index) { return _items.get(index);}
        
        @Override
        public ArrayList<Apartments> getItems()
        {
        return _items;
        }
};

interface AbstractIterator{
    void first();
    void next();
    Boolean isDone();
    Apartments currentItem();
}

class ApartmentIterator implements AbstractIterator
{

    private Collection _collection;
    private int _current;
    
    	public ApartmentIterator(Collection collection) 
        {
		_collection = collection; 
		_current = 0;
	}   
    
    @Override
    public void first()
    {
       _current = 0;
    }

    @Override
    public void next() 
    {
       _current++;
    }

    @Override
    public Boolean isDone() 
    {
       return _current >= _collection.getCount();
    }

    @Override
    public Apartments currentItem()
    {
       if(!isDone()){
       return _collection.get(_current);
       }else{
           System.out.println("collection is not found.");
       return null;
       }
    }
}

/*
    Sensor is the Subject of the Observer Method. It will be followed by the Apartments and Poles.

*/
abstract class Sensor implements Element         
{  
     protected static ArrayList <Sensor> AllSensors = new ArrayList<Sensor>();
    
public int CodeGenerator(int deger)
{
    Random random = new Random();
    int a = random.nextInt(deger);
    return a;
}

    public abstract int sensorID();
    public abstract String sensorName();
    public abstract String sensorModel();
    public abstract boolean notified();
    public abstract void setSensorValue(int value);
    public abstract int getSensorValue();

    //protected ArrayList<Apartments> _subscribedApartments = new ArrayList<>();
    protected ArrayList<Pole> _subscribedPoles = new ArrayList<>();
    AbstractAggregate _subscribedApartments = new Collection();
    
    
    static void printAggregate(AbstractIterator i) {
        
		System.out.println("Subscribed Apartment names are : ");
                
                
		for(i.first();  !i.isDone(); i.next()) {
			System.out.println(i.currentItem().getName());
		}
		System.out.println();
	}
    
    /*
    Iterate over the _subscribedApartments and write sensors' observers.
    */
    
    public void getAllSubs()
    {
    // Create Iterator
    AbstractIterator iterator = _subscribedApartments.CreateIterator();
    printAggregate(iterator);
    }
    
     @Override
        public String toString()
     {
    return "Sensor Model: "+this.sensorModel()+" Sensor Name: "+this.sensorName()+" Sensor ID: "+this.sensorID()+"";
     }
    
    public static void ShowAllSensors()
    {
       for(int i =0;i<AllSensors.size();i++)
       {
           System.out.println(AllSensors.get(i));
       }
    }
    
    public void AddSensor(Sensor sensor)
    {
        AllSensors.add(sensor);
    }
    /*
    //Register the apartments Observers
    */
    public void Attach(Apartments apartmen)
    {
        _subscribedApartments.add(apartmen);
    }
     

    //Unregister from the list of Observers.
    public void Detach(Apartments apartment)
    {
        for(int i = 0 ; i  <=  _subscribedApartments.getCount()  ; i++ ){
           if(this.getName().equals(_subscribedApartments.get(i).getName())) {
               _subscribedApartments.getItems().remove(apartment);
           }
        }
    }
    
    //Register the pole observer
     public void Attach_Pole(Pole pole)
    {
        _subscribedPoles.add(pole);
    }
     
    //Unregister from the list of Observers.
     public void Detach_Pole(Pole pole)
    {
        for(int i = 0;i<= _subscribedPoles.size();i++ ){
           if(this.getName_Pole().equals(_subscribedPoles.get(i).getName_Pole())) {
               _subscribedPoles.remove(pole);
           }
        }
    }    
     
    public void Reset(Sensor sensor)
    {
        for(int i = 0;i<= _subscribedApartments.getCount();i++ )
        {
            
        }
    }

    // set argument to something that helps
    // tell the Observers what happened
    public void Notify() 
    {
        _subscribedApartments.getItems().forEach((subscribedApartment) -> {
            subscribedApartment.Update(this);
            //this.notified() == true;
        });
    }
    
    public void Notify_Pole() 
    {
        _subscribedPoles.forEach((Pole _subscribedPoles1) -> {
            _subscribedPoles1.Update_Pole(Sensor.this);
        });
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

    private Object getName() 
    {
        return this._subscribedApartments;
    }
    
    private Object getName_Pole() 
    {
        return this._subscribedPoles;
    }
}

//An 'Abstract Factory' class
abstract class sensorFactory
{
abstract public Pollution_Sensor createPollutionSensor(int pol);
abstract public Temperature_Sensor createTemperatureSensor(int temp);
abstract public Congestion_Sensor createCongestionSensor(int conges);
abstract public Noise_Sensor createNoiseSensor(int noise);
}

/*
AN CONCRETE SENSORFACTORY CLASS
*/
class ConcreteSensorFactory extends sensorFactory
{
        @Override
        public Pollution_Sensor createPollutionSensor(int pol) 
        {
             Pollution_Sensor sen = new Pollution_Sensor(pol);
            return new Pollution_Sensor(pol);
        }

        @Override
        public Temperature_Sensor createTemperatureSensor(int temp) 
        {
           return new Temperature_Sensor(temp);
        }

        @Override
        public Congestion_Sensor createCongestionSensor(int conges) 
        {
            return new Congestion_Sensor(conges);
        }

        @Override
        public Noise_Sensor createNoiseSensor(int noise) 
        {
            return new Noise_Sensor(noise);
        }
}

//The Client

class BuildSensor
{
public Pollution_Sensor createPollutionSensor(ConcreteSensorFactory sensorFactory, int value){
    return sensorFactory.createPollutionSensor(value);
}

public Temperature_Sensor createTemperatureSensor(ConcreteSensorFactory sensorFactory, int value){
    return sensorFactory.createTemperatureSensor(value);
}

public Congestion_Sensor createCongestionSensor(ConcreteSensorFactory sensorFactory, int value){
    return sensorFactory.createCongestionSensor(value);

}

public Noise_Sensor createNoiseSensor(ConcreteSensorFactory sensorFactory, int value){
    return sensorFactory.createNoiseSensor(value);

}
}

/*
    Visitor pattern
*/
    interface Element{
        public void Accept(Visitor visitor);
    }

    interface Visitor{
        public void Visit(Sensor sensor);
    }

class Sensors
{
protected static ArrayList<Sensor> _sensors = new ArrayList<>();
public void add(Sensor sensor){_sensors.add(sensor);}
public void Accept(Visitor visitor){
for(int i = 0; i < _sensors.size() ; i++){
_sensors.get(i).Accept(visitor);
}
}
}

class ResetVisitor implements Visitor{
    @Override
    public void Visit(Sensor sensor) 
    {
       System.out.println(sensor.sensorName()+" is resetted by admin.");
       sensor.setSensorValue(0);
       System.out.println("new sensorValue is : " + sensor.getSensorValue());    
    }
}

/*
Pollutuion sonsor is a ConcreteSubject
*/

/*
Concrete sensor inherits from Sensor.
*/

class Pollution_Sensor extends Sensor 
{
    private int _pollution;
    private boolean pollutionNoticed;
    
    public Pollution_Sensor(int pollution){
        _pollution = pollution;
    }
    
    public void setPollution(int pollution)
    {
        _pollution = pollution;
        Notify();
    }

    @Override
    public int sensorID() 
    {
        return 0;
    }

    @Override
    public String sensorName() 
    {
        return "Pollution Sensor";
    }

    @Override
    public String sensorModel() 
    {
        return "KF1500";
    }

    @Override
    public boolean notified() 
    {
        return false;
    }

    @Override
    public void setSensorValue(int value) 
    {
        setPollution(value);
    }

    @Override
    public int getSensorValue() 
    {
        return _pollution;
    }

    public Pollution_Sensor createPollutionSensor()
    {
         AllSensors.add(this);
        return new Pollution_Sensor(1);      
    }

    public void calculatePollution(int newPollution)
    {
        newPollution = CodeGenerator(200);
        if(newPollution > 100)
        {
            newPollution = _pollution;
            setPollution(_pollution);
        }
        System.out.println("The pollution is: " + getSensorValue()+ "WARNING!" + notified());
    }
  
    @Override
    public void Accept(Visitor visitor) 
    {
        visitor.Visit(this);
    }
}

/*
Temp sonsor is a ConcreteSubject
*/


/*
Concrete sensor inherits from Sensor.
*/


class Temperature_Sensor extends Sensor 
{
    int _celcius;
/*
    int Kelvin;
    int Fahrenheit;
*/
    
    public Temperature_Sensor(int temp)
    {
        _celcius = temp;
    }
    
    
    @Override
    public int sensorID() 
    {
        return 1;
    }

    @Override
    public String sensorName() 
    {
        return "Temp Sensor";
    }

    @Override
    public String sensorModel()
    {
        return "KF2500";
    }

    @Override
    public boolean notified()
    {
        return false;
    }

    @Override
    public void setSensorValue(int value) 
    {
        setCelcius(value);
    }

    @Override
    public int getSensorValue() 
    {
        return _celcius;
    }

    public Temperature_Sensor createTemperatureSensor()
    {
         AllSensors.add(this);
         return new Temperature_Sensor(1);
    }

    public void setCelcius(int celcius)
    {
        _celcius = celcius;
        Notify();
    }

    
    @Override
    public void Accept(Visitor visitor) {
       visitor.Visit(this);
    }
}

/*
Congestion sonsor is a ConcreteSubject
*/

/*
Concrete sensor inherits from Sensor.
*/

class Congestion_Sensor extends Sensor 
{
    int _congestion;
      
    public Congestion_Sensor(int conges){
    _congestion = conges;
    }

    @Override
    public int sensorID() 
    {
        return 2;
    }

    @Override
    public String sensorName()
    {
        return "congestion";
    }

    @Override
    public String sensorModel()
    {
        return "KF3500";
    }

    @Override
    public boolean notified()
    {
        return false;
    }

    @Override
    public void setSensorValue(int value)
    {
        set_pollution(value);
    }

    @Override
    public int getSensorValue()
    {
        return _congestion;
    }

    public Congestion_Sensor createCongestionSensor()
    {
         AllSensors.add(this);
        return new Congestion_Sensor(1);
    }


    public void set_pollution(int pollution) 
    {
        _congestion = pollution;
        Notify();
    }

    
    @Override
    public void Accept(Visitor visitor) {
        visitor.Visit(this);
    }
}

/*
Noise sonsor is a ConcreteSubject
*/

/*
Concrete sensor inherits from Sensor.
*/
class Noise_Sensor extends Sensor
{
    int _volume;
    
    
    
    public Noise_Sensor( int volume )
    {
    _volume = volume;
    }

    @Override
    public int sensorID() 
    {
        return 3;
    }

    @Override
    public String sensorName() 
    {
        return "noise sensor";
    }

    @Override
    public String sensorModel() 
    {
        return "KF5500";
    }

    @Override
    public boolean notified() 
    {
        return false;
    }

    @Override
    public void setSensorValue(int value) 
    {
        setVolume(value);
    }

    @Override
    public int getSensorValue()
    {
        return _volume;
    }

    public Noise_Sensor createNoiseSensor()
    {
         AllSensors.add(this);
        return new Noise_Sensor(1);
    }

    public void setVolume(int vol)
    {
        _volume = vol;
        Notify();
    }

    @Override
    public void Accept(Visitor visitor) 
    {
        visitor.Visit(this);
    }
}
