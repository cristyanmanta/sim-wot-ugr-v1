/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;
import Simulator.Functions.FunctionModel;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Cristyan
 */
@XmlRootElement ( namespace = "VirtualThing xmlns:IZ=\"http://www.searchofthings.org\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.searchofthings.org VirtualThing.xsd \"", name = "VirtualThing")
public class VirtualThing {
    private int idVirtualThing;
    private String description;
    private String identifier;
    private String keyword;
    private String name;
    
    private String category;
    private String alternateName;
    private String image;
    private String potentialAction;
    private int state;
    private String events;
    private String characteristics;
    private int idSubSmartSpace;

    public VirtualThing(int idVirtualThing, String description, String identifier, String keyword, String name, String category, String alternateName, String image, String potentialAction, int state, String events, String characteristics, int idSubSmartSpace) {
        this.idVirtualThing = idVirtualThing;
        this.description = description;
        this.identifier = identifier;
        this.keyword = keyword;
        this.name = name;
        this.category = category;
        this.alternateName = alternateName;
        this.image = image;
        this.potentialAction = potentialAction;
        this.state = state;
        this.events = events;
        this.characteristics = characteristics;
        this.idSubSmartSpace = idSubSmartSpace;
    }

    
    /**
     * @return the idSubSmartSpace
     */
    public int getIdVirtualThing() {
        return idVirtualThing;
    }

    /**
     * @param idVirtualThing; the idSubSmartSpace to set
     */
    public void setIdVirtualThing(int idVirtualThing) {
        this.idVirtualThing = idVirtualThing;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the alternateName
     */
    public String getAlternateName() {
        return alternateName;
    }

    /**
     * @param alternateName the alternateName to set
     */
    public void setAlternateName(String alternateName) {
        this.alternateName = alternateName;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the potentialAction
     */
    public String getPotentialAction() {
        return potentialAction;
    }

    /**
     * @param potentialAction the potentialAction to set
     */
    public void setPotentialAction(String potentialAction) {
        this.potentialAction = potentialAction;
    }

    /**
     * @return the state
     */
    public int getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     * @return the events
     */
    public String getEvents() {
        return events;
    }

    /**
     * @param events the events to set
     */
    public void setEvents(String events) {
        this.events = events;
    }

    /**
     * @return the characteristics
     */
    public String getCharacteristics() {
        return characteristics;
    }

    /**
     * @param characteristics the characteristics to set
     */
    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }
      
    public void appendsEvent(String info){
        events+=info;
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
}
