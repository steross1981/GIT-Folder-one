/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animal;

/**
 *
 * @author ste
 */
public class Zoo {
    
    private Animal[] animals;
    
    public Zoo() {
        int r;
        animals = new Animal[10];
        for ( int i = 0 ; i < 10; i++ )
        {
            r = (int) Math.round(Math.random());
            if (r==0)
            {
                animals[i] = new Mouse();
                
                
            }else if ( r < 100) {
                animals[i] = new Lion();
            }
            
            
        }
        for ( int i = 0 ; i < 10; i++)
            {
                animals[i].pinStick();
            }
            
    }
    
    public static void main (String[] args) 
    {
        Zoo zoo = new Zoo();
        
    }
}
