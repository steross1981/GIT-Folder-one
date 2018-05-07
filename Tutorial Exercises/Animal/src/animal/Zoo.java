/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

/**
 *
 * @author ste
 */
public class Zoo {

    private Animal[] animals;

   
    
public Zoo() {
        int r;
        animals = new Animal[100];

        for (int i = 0; i < 10; i++) {
            r = (int) Math.round(Math.random());
            if (r == 0) {
                animals[i] = new Mouse();} 
            else
              {
                animals[i] = new Lion();
            }
         
        
        }
         
        
        for (int i = 0; i <10 ; i++)
         
         {
                for (int j = 0;j< 10; j++){
                   
            animals[i].pinstick();
             if ( j % 10 == 0)
                 System.out.println("");
             
             
     
        }
}
    }
public static void main(String[] args){
   
    Zoo myZoo = new Zoo();
   
        
    }
    
}






/*
CHANGED FOR 10 RESULTS INSTEAD OF 100
package animal;

/**
 *
 * @author ste
 
public class Zoo {

    private Animal[] animals;

   
    
public Zoo() {
        int r;
        animals = new Animal[10];

        for (int i = 0; i < 10; i++) {
            r = (int) Math.round(Math.random());
            if (r == 0) {
                animals[i] = new Mouse();
            } else {
                animals[i] = new Lion();
            }
        }
        
        for (int i = 0; i< 10; i++){
            animals[i].pinstick();
        }

    }
public static void main(String[] args){
   
    Zoo myZoo = new Zoo();
    
}
}*/