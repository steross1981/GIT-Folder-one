/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

/**
 *
 * @author ste
 */
public class Person {

    private static  String name;
    private static String address;
    private static String NINumber;
    private static int age;
    static int pay;

    public Person(String personName, String personAddress, String personNINumber, int personAge, int personPay) {

        name = personName;
        address = personAddress;
        NINumber = personNINumber;
        age = personAge;
        pay = personPay;

   
    }

    protected static void list() {
   
            System.out.println("name: " + name + "address" + address );

        }

    



        

    protected void changeNINumber(String newNINumber) {
        NINumber = newNINumber;
    }

    protected void changeAddress(String newAddress) {
        address = newAddress;
    }

 
    }
