/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataBase;
import Entities.VirtualSensor;
import Entities.SubSmartSpace;
import Entities.SmartSpace;
import Entities.VirtualThing;
import Entities.IntelligentZone;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
/**
 *
 * @author Cristyan
 */
public class Connector {
        
    private Connection conector;
    private Statement s;    
      public Connector(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //conector=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wotsimdb", "root", "**********");
            //
            conector=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wotsimdb", "root", "");
            s = conector.createStatement();               
        }catch(SQLException E){System.err.println(E.getMessage());System.err.println(E.getSQLState());
        }catch(ClassNotFoundException E){System.err.println(E.getMessage());
       }    
    }
    
    public Connector(String URL,String user, String Password){
         try{
            conector=DriverManager.getConnection("jdbc:mysql://"+URL, user, Password);
            s = conector.createStatement();
              
        }catch(SQLException E){System.err.println(E.getMessage());System.err.println(E.getSQLState());
        }
    }
    
    public void close(){
        try{
        s.close();
        conector.close();
        }catch(SQLException E){System.err.println(E.getMessage());System.err.println("State: "+E.getSQLState());
        }
    }
    public void saveLog(String Info){
        int newID=0;
        try{
            ResultSet rs = s.executeQuery ("select max(idLog) from Log");    
                while (rs.next())
                {  
                    newID=rs.getInt(1)+1;
                }      
            s.executeUpdate("INSERT INTO `Log` (`idLog`, `Info`) VALUES ("+newID+",'"+Info+"');");   
        }catch(SQLException E){System.err.println(E.getMessage());System.err.println(E.getSQLState());
        }
    }
    
    public void saveIntelligentZone(IntelligentZone IZ){
        int newID=0;
        try{
            ResultSet rs = s.executeQuery ("select max(idIntelligentZone) from IntelligentZone");           
                while (rs.next())
                {  
                    newID=rs.getInt(1)+1;
                }      
            s.executeUpdate("INSERT INTO `IntelligentZone` (`idIntelligentZone`, `classifier`,"
                    + " `description`, `elevation`, `featureCode`, `geoclass`, `identifier`, `keyword`,"
                    + " `latitude`, `longitude`, `locationName`, `registrantCity`, `registrantCountry`,"
                    + " `registrantName`, `registrantOrganizaion`, `registrantPhone`, `registrantStreet`,"
                    + " `webDomain`) VALUES ("+newID+",'"+IZ.getClassifier()+"','"+IZ.getDescription()+"','"+IZ.getElevation()+"','"+
                    IZ.getFeatureCode()+"','"+IZ.getGeoclass()+"','"+IZ.getIdentifier()+"','"+IZ.getKeyword()+"','"+IZ.getLatitude()+"','"+
                    IZ.getLongitude()+"','"+IZ.getLocationName()+"','"+IZ.getRegistrantCity()+"','"+IZ.getRegistrantCountry()+"','"+
                    IZ.getRegistrantName()+"','"+IZ.getRegistrantOrganizaion()+"','"+IZ.getRegistrantPhone()+"','"+IZ.getRegistrantStreet()+"','"+
                    IZ.getWebDomain()+"');");   
        }catch(SQLException E){
            System.err.println(E.getMessage()+"PTA");
        }
    }
    public String[] getNamesIntelligentZones(){
        String [] IntelligentZonesList=new String[0];

        try{
            ResultSet rs = s.executeQuery ("select locationName from IntelligentZone WHERE 1>0");           
            while (rs.next())
            {  
                IntelligentZonesList=java.util.Arrays.copyOf(IntelligentZonesList,IntelligentZonesList.length + 1);
                IntelligentZonesList[IntelligentZonesList.length-1]=rs.getString("locationName");
            }
            return IntelligentZonesList;
        }catch(SQLException E){System.err.println(E.getMessage());System.err.println(E.getSQLState());
        return null;}  
    }
    
    public IntelligentZone[] getIntelligentZones(){
        IntelligentZone[] IntelligentZonesList=new IntelligentZone[0];
        try{
            ResultSet rs = s.executeQuery ("select * from IntelligentZone WHERE 1>0");           
            while (rs.next())
            {  
                IntelligentZonesList=java.util.Arrays.copyOf(IntelligentZonesList,IntelligentZonesList.length + 1);
                IntelligentZonesList[IntelligentZonesList.length-1]=new IntelligentZone(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18));
            }
            return IntelligentZonesList;
        }catch(SQLException E){System.err.println(E.getMessage());System.err.println(E.getSQLState());
        return null;
    }
}
    public void saveSmartSpace(SmartSpace SS){
        int newID=0;
        try{
            ResultSet rs = s.executeQuery ("select max(idSmartSpace) from SmartSpace");           
                while (rs.next())
                {  
                    newID=rs.getInt(1)+1;
                }      
            s.executeUpdate("INSERT INTO `SmartSpace` (`idSmartSpace`, `classifier`,"
                    + " `description`, `elevation`, `featureCode`, `geoclass`, `identifier`, `keyword`,"
                    + " `latitude`, `longitude`, `locationName`, `address`," 
                    + " `idIntelligentZone`) VALUES ("+newID+",'"+SS.getClassifier()+"','"+SS.getDescription()+"','"+SS.getElevation()+"','"+
                    SS.getFeatureCode()+"','"+SS.getGeoclass()+"','"+SS.getIdentifier()+"','"+SS.getKeyword()+"','"+SS.getLatitude()+"','"+
                    SS.getLongitude()+"','"+SS.getLocationName()+"','"+SS.getAddress()+"',"+SS.getidIntelligentZone()+");");   
        }catch(SQLException E){System.err.println(E.getMessage());System.err.println(E.getSQLState());
        }
    }
 
    public SmartSpace[] getSmartSpaces(){
        SmartSpace[] SmartSpaceList=new SmartSpace[0];
        try{
            ResultSet rs = s.executeQuery ("select * from SmartSpace WHERE 1>0");           
            while (rs.next())
            {  
                SmartSpaceList=java.util.Arrays.copyOf(SmartSpaceList,SmartSpaceList.length + 1);
                SmartSpaceList[SmartSpaceList.length-1]=new SmartSpace(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13));
            }
            return SmartSpaceList;
        }catch(SQLException E){System.err.println(E.getMessage());System.err.println(E.getSQLState());
        return null;
    }
}
    public void saveSubSmartSpace(SubSmartSpace SS){
        int newID=0;
        try{
            ResultSet rs = s.executeQuery ("select max(idSubSmartSpace) from SubSmartSpace");           
                while (rs.next())
                {  
                    newID=rs.getInt(1)+1;
                }      
            s.executeUpdate("INSERT INTO `SubSmartSpace` (`idSubSmartSpace`, `classifier`,"
                    + " `description`, `featureCode`, `identifier`, `keyword`,"
                    + "`locationName`, `maxHost`, `idSmartSpace`) VALUES ("+newID+",'"+SS.getClassifier()+"','"+SS.getDescription()+"','"+SS.getFeatureCode()+"','"+SS.getIdentifier()+"','"+SS.getKeyword()+"','"+SS.getLocationName()+"',"+
                   SS.getMaxHost()+" , "+ SS.getidSmartSpace()+");");   
        }catch(SQLException E){System.err.println(E.getMessage());System.err.println(E.getSQLState());
        }
    }
 
    public SubSmartSpace[] getSubSmartSpaces(){
        SubSmartSpace[] SubSmartSpaceList=new SubSmartSpace[0];
        try{
            ResultSet rs = s.executeQuery ("select * from SubSmartSpace WHERE 1>0");           
            while (rs.next())
            {  
                SubSmartSpaceList=java.util.Arrays.copyOf(SubSmartSpaceList,SubSmartSpaceList.length + 1);
                SubSmartSpaceList[SubSmartSpaceList.length-1]=new SubSmartSpace(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
            }
            return SubSmartSpaceList;
        }catch(SQLException E){System.err.println(E.getMessage());System.err.println(E.getSQLState());
        return null;
    }
}

    public void saveVirtualThing(VirtualThing SS){
        int newID=0;
        try{
            ResultSet rs = s.executeQuery ("select max(idVirtualThing) from VirtualThing");           
                while (rs.next())
                {  
                    newID=rs.getInt(1)+1; 
                }      
            s.executeUpdate("INSERT INTO `WoTSimDB`.`VirtualThing` (`idVirtualThing`, `description`, `identifier`, `keyword`, `name`, `category`, `alternateName`, `image`, `potentialAction`, `state`, `events`, `characteristics`, `idSubSmartSpace`) VALUES ("+newID+",'"+SS.getDescription()+"','"+SS.getIdentifier()+"','"+SS.getKeyword()+"','"+SS.getName()+"','"+SS.getCategory()+"','"+SS.getAlternateName()+"','"+
                    SS.getImage()+"','"+SS.getPotentialAction()+"',"+SS.getState()+",'"+SS.getEvents()+"','"+SS.getCharacteristics()+"',"+SS.getIdSubSmartSpace()+");");   
        }catch(SQLException E){System.err.println(E.getMessage());System.err.println(E.getSQLState());
        }
    }
 
    public VirtualThing[] getVirtualThings(){
        VirtualThing[] VirtualThingList=new VirtualThing[0];
        try{
            ResultSet rs = s.executeQuery ("select * from VirtualThing WHERE 1>0");           
            while (rs.next())
            {  
                VirtualThingList=java.util.Arrays.copyOf(VirtualThingList,VirtualThingList.length + 1);
                VirtualThingList[VirtualThingList.length-1]=new VirtualThing(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getInt(10), rs.getString(11), rs.getString(12), rs.getInt(13));
            }
            return VirtualThingList;
        }catch(SQLException E){System.err.println(E.getMessage());System.err.println(E.getSQLState());
        return null;
    }
} 

    public void saveVirtualSensor(VirtualSensor SS){
        int newID=0;
        try{
            ResultSet rs = s.executeQuery ("select max(idVirtualSensor) from VirtualSensor");           
                while (rs.next())
                {  
                    newID=rs.getInt(1)+1;
                }  
        }catch(SQLException E){System.err.println(E.getMessage());System.err.println("State: "+E.getSQLState());}
    }
 
    public VirtualSensor[] getVirtualSensors(){
        VirtualSensor[] VirtualSensorList=new VirtualSensor[0];
        try{
            ResultSet rs = s.executeQuery ("select * from VirtualSensor WHERE 1>0");           
            while (rs.next())
            {  
                VirtualSensorList=java.util.Arrays.copyOf(VirtualSensorList,VirtualSensorList.length + 1);
                VirtualSensorList[VirtualSensorList.length-1]=new VirtualSensor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10), new Date(), rs.getInt(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getInt(16));
            }
            return VirtualSensorList;
        }catch(SQLException E){System.err.println(E.getMessage());System.err.println("State: "+E.getSQLState());
        return null;
    }
}  
}
