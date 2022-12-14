/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simulator;

import Entities.VirtualSensor;
import Entities.SubSmartSpace;
import Entities.SmartSpace;
import Entities.VirtualThing;
import Entities.IntelligentZone;
import Simulator.Functions.FunctionModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Date;
import jdistlib.*;

/**
 *
 * @author Cristyan
 */

public class SimulationEngine {
    
    //Constants for Strings
    private final String[] thingStateNames={"stationary online","offline","moving online"};
        
    //Environmental variables
    private double clock;
    
    private List<Event> futureEventList;
    private int meanT=100;
    private double lambdaT=1d;
    private int meanS=1000;
    private double lambdaS=1d;
    
    
    //Stadistical Counters
    private int thingsQuantity;
    private int thingsArrivals;
    private int thingsMovements;
    private int thingsOfflines;
    
    private int sensorsQuantity;
    private int sensorsBrokens;
    private int sensorsSampling;
    
    private int entityQuantities;
    
    
    //Limit variables
    final private int maxTime;
    final private int maxVirtualSensors;
    final private int maxVirtualThings;
    
    //Relationship Items
    private int idsVTSensor[];      //Asociación Sensor i a id cosa    
    private int idsSubSmartSpace[];
    int[] movOfThings;
    int actStat;
    
    //Entities
    final private IntelligentZone intelligentZones[];
    final private SmartSpace smartSpaces[];
    final private SubSmartSpace subSmartSpaces[];
    private VirtualThing virtualThings[];
    private VirtualSensor virtualSensors[];
    private int[] availableSSS;
    
    //INITIALIZATION ROUTINE
    public SimulationEngine(int maxTime, int maxVirtualSensors, int maxVirtualThings, IntelligentZone[] intelligentZones, SmartSpace[] smartSpaces, SubSmartSpace[] subSmartSpaces, VirtualThing[] virtualThings, VirtualSensor[] virtualSensors) {
        //Stop Simulation // Stopping Event
        this.maxTime = maxTime;
        this.maxVirtualSensors = maxVirtualSensors;
        this.maxVirtualThings = maxVirtualThings;
        //Initialize system state
        this.intelligentZones = intelligentZones;
        this.smartSpaces = smartSpaces;
        this.subSmartSpaces = subSmartSpaces;
        this.virtualThings = virtualThings;
        this.virtualSensors = virtualSensors;
        
        availableSSS= new int[subSmartSpaces.length];
        for (int i=0; i<subSmartSpaces.length;i++){
            availableSSS[i]=subSmartSpaces[i].getMaxHost();
        }
        //Set simulation CLOCK to zero   
        clock=0;      
        //Intialize stastistical counter
        thingsQuantity = 0;
        thingsArrivals = 0;
        thingsMovements = 0;
        thingsOfflines = 0;
        sensorsQuantity = 0;
        sensorsBrokens = 0;
        sensorsSampling = 0;
        entityQuantities = 0;
               
        //Initialize EventList        
        futureEventList=new ArrayList<>();
        
        //Pre-scheduling of Events

        futureEventList.add(new Event(maxTime, 0,0));   
        Exponential exp=new Exponential(lambdaT);  
        
        double nt=0;
        for(int i=0; i<virtualThings.length;i++){
            nt+= meanT*exp.random();
            futureEventList.add(new Event(nt,1,i));          
            futureEventList.add(new Event(nt+1,5,i));
        }     
        sortEvents();
        Simulate();
        
    }
    
    public void Simulate(){        
        while((virtualThings.length<maxVirtualThings) && (virtualSensors.length < maxVirtualSensors)){
            //Time Routine  
                //Determine next Event
            Event currentEvent=futureEventList.get(0);
            clock=currentEvent.getTime();
            /*Event Routine*/
            executeEvent(currentEvent);
            futureEventList.remove(0);
            sortEvents();
            
        }
        System.err.println("Compute Estimates Of Interest");
    }
    
    private void sortEvents(){
                Comparator <Event> event_order = new Comparator<Event>() {
            public int compare(Event e1, Event e2) {
                if (e2.getTime()>e1.getTime()){
                    return -1;
                }
                if (e2.getTime()<e1.getTime()){
                    return 1;
                }
                return 0;
            }
        };       
        Collections.sort(futureEventList,event_order);
    }
    
    private void executeEvent(Event event){
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
    */  
        Exponential exp=new Exponential(lambdaT);
        switch (event.getType()){
            case 0:
                //dispose
                break;
            case 1:
                int nextSSS=FunctionModel.calcNextSubSpace(idsSubSmartSpace);
                if(availableSSS[nextSSS]>0){
                    virtualThings[event.getId()].setState(0);
                    virtualThings[event.getId()].setIdSubSmartSpace(nextSSS);
                    
                    availableSSS[nextSSS]--;
                    thingsArrivals++;
                    
                    futureEventList.add(new Event(clock + exp.random()*500,2,event.getId()));   /*hay cola!!!*/                 
                }else{                    
                    futureEventList.add(new Event(clock + exp.random()*10,1,event.getId()));
                }
                break;
            case 2:
                virtualThings[event.getId()].setState(2);
                
                availableSSS[virtualThings[event.getId()].getIdSubSmartSpace()]--;
                thingsMovements++;
                
                int nextSt=FunctionModel.calcNextState(2);
                if(nextSt==0){
                    futureEventList.add(new Event(clock + exp.random()*200,1,event.getId()));
                }else{
                    futureEventList.add(new Event(clock + exp.random()*200,3,event.getId()));
                }
                break;
            case 3:
                virtualThings[event.getId()].setState(1);
                
                thingsOfflines++;

                nextSt=FunctionModel.calcNextState(1);
                if(nextSt==0){
                    futureEventList.add(new Event(clock + exp.random()*200,1,event.getId()));
                }else{
                    futureEventList.add(new Event(clock + exp.random()*200,4,event.getId()));
                }
                break;
            case 4:
                virtualThings[event.getId()].setState(1);
                
                thingsOfflines--;
                
                futureEventList.add(new Event(clock + exp.random()*200,1,event.getId()));
                break;
            case 5:
                virtualSensors[event.getId()].setState(0);
                virtualSensors[event.getId()].setValue(FunctionModel.measure(0, 0, 120, 1D));
                
                if(FunctionModel.calcNextFailure(0)==0){
                    futureEventList.add(new Event(clock + 60,5,event.getId()));
                }else{
                    futureEventList.add(new Event(clock + exp.random()*200,6,event.getId()));
                }                
                break;
            case 6:
                virtualSensors[event.getId()].setState(1);
                
                futureEventList.add(new Event(clock + exp.random()*1000,7,event.getId()));                
                break;
            case 7:
                virtualSensors[event.getId()].setState(0);
                
                futureEventList.add(new Event(clock + 60,5,event.getId()));
                
                break;
            case 8:
                break;
            case 9:
                break;
            default:
                break;
        }
    }
    
    
    public int createThings(){//ret Num Things Created
        return 0;
    }
    public void createSensors(){//ret Num Sensors Created
        //AGREGAR VALOR AL ARREGLO DE RELACIOPN SENSOR COSA     
        /*
        VirtualSensor[] TemplateSensors=new VirtualSensor[5];
        TemplateSensors[0]=new VirtualSensor(0,"Temperature Sensor","Identifier","Keyw",0,"Events: ","Characteristics","Classifier","Degree","Temperature",new Date(),0,1,0,100,0);
        TemplateSensors[1]=new VirtualSensor(0,"Humidity Sensor","Identifier","Keyw",0,"Events: ","Characteristics","Classifier","Degree","Temperature",new Date(),0,1,0,100,0);
        TemplateSensors[2]=new VirtualSensor(0,"PH Sensor","Identifier","Keyw",0,"Events: ","Characteristics","Classifier","Degree","Temperature",new Date(),0,1,0,100,0);
        TemplateSensors[3]=new VirtualSensor(0,"Preassure Sensor","Identifier","Keyw",0,"Events: ","Characteristics","Classifier","Degree","Temperature",new Date(),0,1,0,100,0);
        TemplateSensors[4]=new VirtualSensor(0,"Distance Sensor","Identifier","Keyw",0,"Events: ","Characteristics","Classifier","Degree","Temperature",new Date(),0,1,0,100,0);
        
        int nSensor=(int)((TemplateSensors.length-1)*Math.random());
        VirtualSensor newSensor=TemplateSensors[nSensor];
        
        int idThing=(int)(Math.random()*virtualThings.length);
        System.err.print("idt: "+idThing+"  virtualThings.length:"+virtualThings.length);
        /*
        newSensor.setIdVirtualSensor(virtualSensors.length+1);
        newSensor.setVirtualThing_idVirtualThing(idThing+1);
        newSensor.setVirtualThing_SubSmartSpace_idSubSmartSpace(virtualThings[idThing].getSubSmartSpace_idSubSmartSpace());
        newSensor.setVirtualThing_SubSmartSpace_SmartSpace_idSmartSpace(virtualThings[idThing].getSubSmartSpace_SmartSpace_idSmartSpace());
        newSensor.setVirtualThing_SubSmartSpace_SmartSpace_IntelligentZone_idIntelligentZone(virtualThings[idThing].getSubSmartSpace_SmartSpace_IntelligentZone_idIntelligentZone());
*//*
        VirtualSensor[] Tmp=java.util.Arrays.copyOf(virtualSensors,virtualSensors.length + 1);
        Tmp[virtualSensors.length]=newSensor;
        virtualSensors=Tmp;

        idsVTSensor=java.util.Arrays.copyOf(idsVTSensor, idsVTSensor.length+1);
        idsVTSensor[idsVTSensor.length-1]=newSensor.getIdVirtualThing();
*/
    }
}
