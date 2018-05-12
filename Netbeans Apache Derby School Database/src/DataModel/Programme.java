/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

/**
 *
 * @author ste
 */
public class Programme {
    
    private int programmeCode;
    private int level;
    private String title;

    /**
     *
     * @param progCod programme code
     * @param lev programme level
     * @param title programme title
     */
    
    public Programme(int progCod, int lev, String title)
            
    {
        this.programmeCode = progCod;
        this.level = lev;
        this.title = title;
              
        
    }
    
    /** returns programme code
     *
     * @return returns code
     */
    public int getCode()
   {
       return programmeCode;
   }
   
    /** returns programme level
     *
     * @return returns programme level
     */
    public int getLevel()
   {
       return level;
   }
    
    /** returns programme title
     *
     * @return returns programme title
     */
    public String getTitle()
   {
       return title;
   }
    

    
    
}
