/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataModel;

/**
 *
 * @author ste
 */
public class Venue {
    
    private int venueID;
    private int hireCost;
    private int venueAddressID;
    private String city;
    private String venuePcode;
    private String venueName;
    private String venueAddress;
    
    public Venue(int hC, String c, String pCode, String vN,String add)
    {
        venueAddress = add;
        hireCost = hC;
        city = c;
        venuePcode = pCode;
       
        venueName = vN;
    }

    /**
     * @return the venueID
     */
    public int getVenueID() {
        return venueID;
    }

    /**
     * @return the hireCost
     */
    public int getHireCost() {
        return hireCost;
    }

    /**
     * @return the venueAddressID
     */
    public int getVenueAddressID() {
        return venueAddressID;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @return the venuePcode
     */
    public String getVenuePcode() {
        return venuePcode;
    }

    /**
     * @return the venueName
     */
    public String getVenueName() {
        return venueName;
    }

    /**
     * @return the venueAddress
     */
    public String getVenueAddress() {
        return venueAddress;
    }
    
}
