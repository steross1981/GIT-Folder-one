/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataModel;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author ste
 */
public class Event {

    /**
     * @return the eventType
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * @param eventType the eventType to set
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the time
 

    /**
     * @return the fixedFee
     */
    public int getFixedFee() {
        return fixedFee;
    }

    /**
     * @param fixedFee the fixedFee to set
     */
    public void setFixedFee(int fixedFee) {
        this.fixedFee = fixedFee;
    }

    /**
     * @return the venueID
     */
    public int getVenueID() {
        return venueID;
    }

    /**
     * @param venueID the venueID to set
     */
    public void setVenueID(int venueID) {
        this.venueID = venueID;
    }

    /**
     * @return the eventName
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * @param eventName the eventName to set
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    private String eventType;
    private Date date;

    private int fixedFee;
    private int customerID;
    private int venueID;
    private String eventName;

    public Event(String evType, Date d,String nam) {
        
        eventType = evType;
        date = d;


        
        eventName = nam;

    }

    /**
     * @return the customerID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }



}
