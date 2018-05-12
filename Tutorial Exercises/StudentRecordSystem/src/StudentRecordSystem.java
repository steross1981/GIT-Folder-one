/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ste
 */
public  class StudentRecordSystem {
    
 
   
    
    StudentRecord students[] = new StudentRecord[4];
    
     public StudentRecordSystem()
    {
       
        students[0] = new StudentRecord("ste",23,"Physics");
        students[1] = new StudentRecord("bob",88,"Physics");
        students[2] = new StudentRecord("Jim",41,"Physics");
        students[3] = new StudentRecord("Vicky",75,"Physics");
    }

  
      public void print()
    {
        for( int i = 0; i < students.length; i++ )
            students[i].print();
    }
      
      public static void main (String[] args) 
              
      {
         
          StudentRecordSystem studentsrec = new StudentRecordSystem();
         studentsrec.print();
      }
  
    
}

