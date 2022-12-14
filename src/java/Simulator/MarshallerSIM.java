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
import DataBase.Connector;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Cristyan
 */
public class MarshallerSIM {
    private static Connector con=new Connector();

    public MarshallerSIM() {            

    }
    
    public static int Marshall(File mainFolder, IntelligentZone[] IntelligentZones,SmartSpace[] smartSpaces,SubSmartSpace[] subSmartSpaces,VirtualThing[] virtualThings,VirtualSensor[] virtualSensors){
        /*
        try{
            if(!mainFolder.exists()){mainFolder.mkdir();}
            for(IntelligentZone intelliZone: IntelligentZones){            
                JAXBContext context = JAXBContext.newInstance(IntelligentZone.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                FileOutputStream fos = new FileOutputStream(mainFolder.toString()+"/"+intelliZone.getURL());
                marshaller.marshal(intelliZone, fos);
                fos.close();            
                File subFolder=new File(mainFolder.toString()+"/"+intelliZone.getPath());
                if(!subFolder.exists()){subFolder.mkdir();}           
            }
            for(SmartSpace smartS: smartSpaces){
                JAXBContext context = JAXBContext.newInstance(SmartSpace.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                FileOutputStream fos = new FileOutputStream(mainFolder.toString()+"/"+smartS.getURL());
                marshaller.marshal(smartS, fos);
                fos.close();            
                File subFolder=new File(mainFolder.toString()+"/"+smartS.getPath());
                if(!subFolder.exists()){subFolder.mkdir();}
            }
            for(SubSmartSpace subSSpace: subSmartSpaces){
                JAXBContext context = JAXBContext.newInstance(SubSmartSpace.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                FileOutputStream fos = new FileOutputStream(mainFolder.toString()+"/"+subSSpace.getURL());
                marshaller.marshal(subSSpace, fos);
                fos.close();            
                File subFolder=new File(mainFolder.toString()+"/"+subSSpace.getPath());
                if(!subFolder.exists()){subFolder.mkdir();}
            }
            for(VirtualThing VThing: virtualThings){
                JAXBContext context = JAXBContext.newInstance(VirtualThing.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                FileOutputStream fos = new FileOutputStream(mainFolder.toString()+"/"+VThing.getURL());
                marshaller.marshal(VThing, fos);
                fos.close();            
                File subFolder=new File(mainFolder.toString()+"/"+VThing.getPath());
                if(!subFolder.exists()){subFolder.mkdir();}
            }
            for(VirtualSensor VSensor: virtualSensors){
                JAXBContext context = JAXBContext.newInstance(VirtualSensor.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                FileOutputStream fos = new FileOutputStream(mainFolder.toString()+"/"+VSensor.getURL());
                marshaller.marshal(VSensor, fos);
                fos.close();
            }
        }catch(IOException IO){
            System.err.println("Marshal: "+IO.getMessage());
            return(-1);
        }catch(JAXBException JB){
            System.err.println("Marshal: "+JB.getMessage());
            return(-1);
        }   
                */
        return 0;
    }

    public static int Marshall(File mainFolder,VirtualThing virtualThing, String appendsLog){
        //LOG
        /*
        try{
            con.saveLog(appendsLog);
            JAXBContext context = JAXBContext.newInstance(VirtualThing.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            FileOutputStream fos = new FileOutputStream(mainFolder.toString()+"/"+virtualThing.getURL());
            marshaller.marshal(virtualThing, fos);
            fos.close();            
            File subFolder=new File(mainFolder.toString()+"/"+virtualThing.getPath());
            if(!subFolder.exists()){subFolder.mkdir();}
        }catch(IOException IO){
            System.err.println("Marshal: Virtual Things: "+IO.getMessage());
            return(-1);
        }catch(JAXBException JB){
            System.err.println("Marshal: Virtual Things: "+JB.getMessage());
            return(-1);
        }   
                */
        return 0;        
    }
    public static int Marshall(File mainFolder, VirtualSensor virtualSensor){
        /*
        try{
            JAXBContext context = JAXBContext.newInstance(VirtualSensor.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            FileOutputStream fos = new FileOutputStream(mainFolder.toString()+"/"+virtualSensor.getURL());
            marshaller.marshal(virtualSensor, fos);
            fos.close();
        return -1;
                }catch(IOException IO){
            //System.err.println("Marshal: Virtual Sensors: "+IO.getMessage());
            return(-1);
        }catch(JAXBException JB){
            //System.err.println("Marshal: Virtual Sensors: "+JB.getMessage());
                
            return(1);
        }  
                */
        return 0;
    }    
}
