
package DataModel;

/** This class defines a Module and contains methods for setting and retrieving its attributes
 *
 * @author ste
 */
public class Module extends Programme {
    
    // title of a module
    private String title;
    // code to identify modues
    private int uniqueCode;
    // level of the module
    private int level; 


  
    /**
     *
     * @param titl title of module
     * @param unicod module code
     * @param lev level of the module
     */
    //constructor for a module initialises its attributes
    public Module (String titl, int unicod, int lev)
    {
        super(lev, unicod, titl);
        title = titl;
        uniqueCode = unicod;
        level = lev;
        
        
    }
            
    /** returns the title of the module
     *
     * @return returns title of module
     */
    public String getTitle()
    {
        return title;
    }
    
    /**returns the modules code 
     *
     * @return returns the modules code
     */
    public int getCode()
    {
        return uniqueCode;
    } 

    /** returns the module level
     *
     * @return returns module level
     */
    public int getLev()
    {
        return level;
    }
            

}
