/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se311;

/**
 *
 * @author Group 4
 */
public class SE311 
{
    
    
abstract class Location 
{
    
}

abstract class neighbourhood extends Location
{
    
}

abstract class street extends neighbourhood
{
    
}

abstract class apartment extends street
{
    
}

abstract class poles extends street
{
    
}
    
abstract class Sensor
{
    
}

abstract class Temperature_Sensor extends Sensor
{
    
}


abstract class Pollution_Sensor extends Sensor
{
    
}

abstract class Congestion_Sensor extends Sensor
{
    
}

abstract class Noise_Sensor extends Sensor
{
    
}

}