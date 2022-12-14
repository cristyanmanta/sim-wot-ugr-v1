/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Entities;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
/**
 *
 * @author Cristyan
 */
@XmlRootElement ( namespace = "VirtualSensor xmlns:IZ=\"http://www.searchofthings.org\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.searchofthings.org VirtualSensor.xsd \"", name = "VirtualSensor")
public class VirtualSensor {
    private int idVirtualSensor;
    private String description;
    private String identifier;
    private String keyword;
    private int state;
    private String events;
    private String characteristics;
    private String classifier;
    private String measure;
    private String observedProperty;
    private Date resultTime;
    private int value;
    private int PDF;
    private int minValue;
    private int maxValue;
    private int idVirtualThing;

    public VirtualSensor(int idVirtualSensor, String description, String identifier, String keyword, int state, String events, String characteristics, String classifier, String measure, String observedProperty, Date resultTime, int value, int PDF, int minValue, int maxValue, int idVirtualThing) {
        this.idVirtualSensor = idVirtualSensor;
        this.description = description;
        this.identifier = identifier;
        this.keyword = keyword;
        this.state = state;
        this.events = events;
        this.characteristics = characteristics;
        this.classifier = classifier;
        this.measure = measure;
        this.observedProperty = observedProperty;
        this.resultTime = resultTime;
        this.value = value;
        this.PDF = PDF;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.idVirtualThing = idVirtualThing;
    }
    /**
     * @return the idVirtualSensor
     */
    public int getIdVirtualSensor() {
        return idVirtualSensor;
    }

    /**
     * @param idVirtualSensor the idVirtualSensor to set
     */
    public void setIdVirtualSensor(int idVirtualSensor) {
        this.idVirtualSensor = idVirtualSensor;
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
     * @return the measure
     */
    public String getMeasure() {
        return measure;
    }

    /**
     * @param measure the measure to set
     */
    public void setMeasure(String measure) {
        this.measure = measure;
    }

    /**
     * @return the observedProperty
     */
    public String getObservedProperty() {
        return observedProperty;
    }

    /**
     * @param observedProperty the observedProperty to set
     */
    public void setObservedProperty(String observedProperty) {
        this.observedProperty = observedProperty;
    }

    /**
     * @return the resultTime
     */
    public Date getResultTime() {
        return resultTime;
    }

    /**
     * @param resultTime the resultTime to set
     */
    public void setResultTime(Date resultTime) {
        this.resultTime = resultTime;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return the minValue
     */
    public int getMinValue() {
        return minValue;
    }

    /**
     * @param minValue the minValue to set
     */
    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    /**
     * @return the maxValue
     */
    public int getMaxValue() {
        return maxValue;
    }

    /**
     * @param maxValue the maxValue to set
     */
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * @return the PDF
     */
    public int getPDF() {
        return PDF;
    }

    /**
     * @param PDF the PDF to set
     */
    public void setPDF(int PDF) {
        this.PDF = PDF;
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
     * @return the idVirtualThing
     */
    public int getIdVirtualThing() {
        return idVirtualThing;
    }

    /**
     * @param idVirtualThing the idVirtualThing to set
     */
    public void setIdVirtualThing(int idVirtualThing) {
        this.idVirtualThing = idVirtualThing;
    }
   
}
