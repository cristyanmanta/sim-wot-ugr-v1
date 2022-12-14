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
@XmlRootElement ( namespace = "IntelligentZone xmlns:IZ=\"http://www.searchofthings.org\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.searchofthings.org IntelligentZone.xsd \"", name = "IntelligentZone")
public class IntelligentZone {
    private int idIntelligentZone;
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
    private String registrantCity;
    private String registrantCountry;
    private String registrantName;
    private String registrantOrganizaion;
    private String registrantPhone;
    private String registrantStreet;
    private String webDomain;

    public IntelligentZone(int idIntelligentZone, String classifier, String description, String elevation, String featureCode, String geoclass, String identifier, String keyword, String latitude, String longitude, String locationName, String registrantCity, String registrantCountry, String registrantName, String registrantOrganizaion, String registrantPhone, String registrantStreet, String webDomain) {
        this.idIntelligentZone = idIntelligentZone;
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
        this.registrantCity = registrantCity;
        this.registrantCountry = registrantCountry;
        this.registrantName = registrantName;
        this.registrantOrganizaion = registrantOrganizaion;
        this.registrantPhone = registrantPhone;
        this.registrantStreet = registrantStreet;
        this.webDomain = webDomain;
    }
  
    public String getPath(){
        return String.format("/IZ%04d", idIntelligentZone);                      
    }
    public String getURL(){
        return String.format("/IZ%04d.xml", idIntelligentZone);
    }
    
    /**
     * @return the idIntelligentZone
     */
    public int getIdIntelligentZone() {
        return idIntelligentZone;
    }

    /**
     * @param idIntelligentZone the idIntelligentZone to set
     */
    public void setIdIntelligentZone(int idIntelligentZone) {
        this.idIntelligentZone = idIntelligentZone;
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
     * @return the registrantCity
     */
    public String getRegistrantCity() {
        return registrantCity;
    }

    /**
     * @param registrantCity the registrantCity to set
     */
    public void setRegistrantCity(String registrantCity) {
        this.registrantCity = registrantCity;
    }

    /**
     * @return the registrantCountry
     */
    public String getRegistrantCountry() {
        return registrantCountry;
    }

    /**
     * @param registrantCountry the registrantCountry to set
     */
    public void setRegistrantCountry(String registrantCountry) {
        this.registrantCountry = registrantCountry;
    }

    /**
     * @return the registrantName
     */
    public String getRegistrantName() {
        return registrantName;
    }

    /**
     * @param registrantName the registrantName to set
     */
    public void setRegistrantName(String registrantName) {
        this.registrantName = registrantName;
    }

    /**
     * @return the registrantOrganizaion
     */
    public String getRegistrantOrganizaion() {
        return registrantOrganizaion;
    }

    /**
     * @param registrantOrganizaion the registrantOrganizaion to set
     */
    public void setRegistrantOrganizaion(String registrantOrganizaion) {
        this.registrantOrganizaion = registrantOrganizaion;
    }

    /**
     * @return the registrantPhone
     */
    public String getRegistrantPhone() {
        return registrantPhone;
    }

    /**
     * @param registrantPhone the registrantPhone to set
     */
    public void setRegistrantPhone(String registrantPhone) {
        this.registrantPhone = registrantPhone;
    }

    /**
     * @return the registrantStreet
     */
    public String getRegistrantStreet() {
        return registrantStreet;
    }

    /**
     * @param registrantStreet the registrantStreet to set
     */
    public void setRegistrantStreet(String registrantStreet) {
        this.registrantStreet = registrantStreet;
    }

    /**
     * @return the webDomain
     */
    public String getWebDomain() {
        return webDomain;
    }

    /**
     * @param webDomain the webDomain to set
     */
    public void setWebDomain(String webDomain) {
        this.webDomain = webDomain;
    }
}
