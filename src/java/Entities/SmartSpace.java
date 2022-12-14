/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Cristyan
 */
@XmlRootElement ( namespace = "SmartSpace xmlns:IZ=\"http://www.searchofthings.org\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.searchofthings.org SmartSpace.xsd \"", name = "SmartSpace")
public class SmartSpace {
    private int idSmartSpace;
    private String classifier;
    private String description;
    private String elevation;
    private String featureCode;
    private String geoclass;
    private String identifier;
    private String keyword;
    private String latitude;
    private String longitude;   
    private String locationName;
    private String address; 
    private int idIntelligentZone;

    public SmartSpace(int idSmartSpace, String classifier, String description, String elevation, String featureCode, String geoclass, String identifier, String keyword, String latitude, String longitude, String locationName, String address, int idIntelligentZone) {
        this.idSmartSpace = idSmartSpace;
        this.classifier = classifier;
        this.description = description;
        this.elevation = elevation;
        this.featureCode = featureCode;
        this.geoclass = geoclass;
        this.identifier = identifier;
        this.keyword = keyword;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationName = locationName;
        this.idIntelligentZone = idIntelligentZone;
        this.address = address;
    }
    
    public String getPath(){
        return String.format("IZ%04d", getidIntelligentZone())+ 
               String.format("/SS%04d", idSmartSpace);                      
    }
    
    public String getURL(){
        return String.format("IZ%04d", getidIntelligentZone())+ 
               String.format("/SS%04d.xml", idSmartSpace);
    }
    /**
     * @return the idSmartSpace
     */
    public int getIdSmartSpace() {
        return idSmartSpace;
    }

    /**
     * @param idSmartSpace the idSmartSpace to set
     */
    public void setIdSmartSpace(int idSmartSpace) {
        this.idSmartSpace = idSmartSpace;
    }

    /**
     * @return the classifier
     */
    public String getClassifier() {
        return classifier;
    }

    /**
     * @param classifier the classifier to set
     */
    public void setClassifier(String classifier) {
        this.classifier = classifier;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the elevation
     */
    public String getElevation() {
        return elevation;
    }

    /**
     * @param elevation the elevation to set
     */
    public void setElevation(String elevation) {
        this.elevation = elevation;
    }

    /**
     * @return the featureCode
     */
    public String getFeatureCode() {
        return featureCode;
    }

    /**
     * @param featureCode the featureCode to set
     */
    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    /**
     * @return the geoclass
     */
    public String getGeoclass() {
        return geoclass;
    }

    /**
     * @param geoclass the geoclass to set
     */
    public void setGeoclass(String geoclass) {
        this.geoclass = geoclass;
    }

    /**
     * @return the identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * @param identifier the identifier to set
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the locationName
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * @param locationName the locationName to set
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the IntelligentZone_idIntelligentZone
     */
    public int getidIntelligentZone() {
        return idIntelligentZone;
    }

    /**
     * @param idIntelligentZone the IntelligentZone_idIntelligentZone to set
     */
    public void setidIntelligentZone(int idIntelligentZone) {
        this.idIntelligentZone = idIntelligentZone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
}
