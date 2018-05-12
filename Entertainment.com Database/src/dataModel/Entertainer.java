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
public class Entertainer {
    
    private String name;
    private String entType;
    private int fee;
    
    public Entertainer(String n, String t, int f)
    {
        name = n;
        entType = t;
        fee = f;
                       
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
     * @return the entType
     */
    public String getEntType() {
        return entType;
    }

    /**
     * @param entType the entType to set
     */
    public void setEntType(String entType) {
        this.entType = entType;
    }

    /**
     * @return the fee
     */
    public int getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(int fee) {
        this.fee = fee;
    }
    
}
