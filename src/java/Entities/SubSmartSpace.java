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
@XmlRootElement ( namespace = "SubSmartSpace xmlns:IZ=\"http://www.searchofthings.org\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.searchofthings.org SubSmartSpace.xsd \"", name = "SubSmartSpace")
public class SubSmartSpace {
    private int idSubSmartSpace;
    private String classifier;
    private String description;
    private String featureCode;
    private String identifier;
    private String keyword;
    private String locationName;
    private int maxHost;
    private int idSmartSpace;

    public SubSmartSpace(int idSubSmartSpace, String classifier, String description, String featureCode, String identifier, String keyword, String locationName, int maxHost, int idSmartSpace) {
        this.idSubSmartSpace = idSubSmartSpace;
        this.classifier = classifier;
        this.description = description;
        this.featureCode = featureCode;
        this.identifier = identifier;
        this.keyword = keyword;
        this.locationName = locationName;
        this.maxHost = maxHost;
        this.idSmartSpace = idSmartSpace;
    }

    /**
     * @return the idSubSmartSpace
     */
    public int getIdSubSmartSpace() {
        return idSubSmartSpace;
    }

    /**
     * @param idSubSmartSpace the idSubSmartSpace to set
     */
    public void setIdSubSmartSpace(int idSubSmartSpace) {
        this.idSubSmartSpace = idSubSmartSpace;
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
     * @return the SmartSpace_idSmartSpace
     */
    public int getidSmartSpace() {
        return idSmartSpace;
    }

    /**
     * @param SmartSpace_idSmartSpace the SmartSpace_idSmartSpace to set
     */
    public void setidSmartSpace(int SmartSpace_idSmartSpace) {
        this.idSmartSpace = SmartSpace_idSmartSpace;
    }

    /**
     * @return the maxHost
     */
    public int getMaxHost() {
        return maxHost;
    }

    /**
     * @param maxHost the maxHost to set
     */
    public void setMaxHost(int maxHost) {
        this.maxHost = maxHost;
    }
    
}
