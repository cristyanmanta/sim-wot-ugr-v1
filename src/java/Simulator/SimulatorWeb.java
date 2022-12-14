/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simulator;

import Entities.IntelligentZone;
import Entities.SmartSpace;
import Entities.SubSmartSpace;
import Entities.VirtualSensor;
import Entities.VirtualThing;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import jdistlib.math.VectorMath;

@ManagedBean
@ApplicationScoped
public class SimulatorWeb {
    private int maxTime=1000;
    private int maxVirtualSensors=1000;
    private int maxVirtualThings=1000;
    private int lambdaVT=1;
    private int lambdaVS=1;
    private int PDFVT=1;
    private int PDFVS=1;
    
    private final SimulationEngine SimuEngine;
    private int Time;
    private int ThingMps=0;
    private int ThingSps=0;
    
    /**
     * Creates a new instance of SimulatorWeb
     */
    public SimulatorWeb() {
        IntelligentZone[] Zones=new IntelligentZone[0];
        SmartSpace[] Spaces = new SmartSpace[0];
        SubSmartSpace[] SubSmart = new SubSmartSpace[0];
        VirtualThing[] VThings = new VirtualThing[0];
        VirtualSensor[] VSensors = new VirtualSensor[0];
        
        SimuEngine=new SimulationEngine(maxTime,maxVirtualSensors,maxVirtualThings,Zones,Spaces,SubSmart,VThings,VSensors);        
    }
    
    public void Step(){
        /*SimuEngine.Step();
        this.setTime(SimuEngine.getTime());
        this.setThingMps(SimuEngine.getThingMps());
        this.setThingSps(SimuEngine.getThingSps());*/
    }
    public void Restore(){        /*
        this.setTime(SimuEngine.getTime());
        this.setThingMps(SimuEngine.getThingMps());
        this.setThingSps(SimuEngine.getThingSps());*/
    }
    
    public void Start(){
        SimuEngine.Simulate();
    }

    /**
     * @return the maxTime
     */
    public int getMaxTime() {
        return maxTime;
    }

    /**
     * @param maxTime the maxTime to set
     */
    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

    /**
     * @return the maxVirtualSensors
     */
    public int getMaxVirtualSensors() {
        return maxVirtualSensors;
    }

    /**
     * @param maxVirtualSensors the maxVirtualSensors to set
     */
    public void setMaxVirtualSensors(int maxVirtualSensors) {
        this.maxVirtualSensors = maxVirtualSensors;
    }

    /**
     * @return the maxVirtualThings
     */
    public int getMaxVirtualThings() {
        return maxVirtualThings;
    }

    /**
     * @param maxVirtualThings the maxVirtualThings to set
     */
    public void setMaxVirtualThings(int maxVirtualThings) {
        this.maxVirtualThings = maxVirtualThings;
    }

    /**
     * @return the lambdaVT
     */
    public int getLambdaVT() {
        return lambdaVT;
    }

    /**
     * @param lambdaVT the lambdaVT to set
     */
    public void setLambdaVT(int lambdaVT) {
        this.lambdaVT = lambdaVT;
    }

    /**
     * @return the lambdaVS
     */
    public int getLambdaVS() {
        return lambdaVS;
    }

    /**
     * @param lambdaVS the lambdaVS to set
     */
    public void setLambdaVS(int lambdaVS) {
        this.lambdaVS = lambdaVS;
    }

    /**
     * @return the PDFVT
     */
    public int getPDFVT() {
        return PDFVT;
    }

    /**
     * @param PDFVT the PDFVT to set
     */
    public void setPDFVT(int PDFVT) {
        this.PDFVT = PDFVT;
    }

    /**
     * @return the PDFVS
     */
    public int getPDFVS() {
        return PDFVS;
    }

    /**
     * @param PDFVS the PDFVS to set
     */
    public void setPDFVS(int PDFVS) {
        this.PDFVS = PDFVS;
    }

    /**
     * @return the Time
     */
    public int getTime() {
        return Time;
    }

    /**
     * @param Time the Time to set
     */
    public void setTime(int Time) {
        this.Time = Time;
    }

    /**
     * @return the ThingMps
     */
    public int getThingMps() {
        return ThingMps;
    }

    /**
     * @param ThingMps the ThingMps to set
     */
    public void setThingMps(int ThingMps) {
        this.ThingMps = ThingMps;
    }

    /**
     * @return the ThingSps
     */
    public int getThingSps() {
        return ThingSps;
    }

    /**
     * @param ThingSps the ThingSps to set
     */
    public void setThingSps(int ThingSps) {
        this.ThingSps = ThingSps;
    }
    
    
}
