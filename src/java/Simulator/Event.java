/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simulator;

/**
 *
 * @author Cristyan
 */
public class Event {
    private double time;
    private int type;
    private int id;
    /*
    
    Type    Description
    
    0       End Simulation
    1       Arrival of a new Vthing
    2       Departure of a Vthing
    3       Disconnection of a Vthing
    4       Reconnection of a Vthing
    
    5       Sampling of a Sensor
    6       Failure of a Sensor
    7       Repair of a sensor
    8       
    9  
    
    */   

    public Event(double time, int type, int id) {
        this.time = time;
        this.type = type;
        this.id = id;
    }

    /**
     * @return the time
     */
    public double getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
}
