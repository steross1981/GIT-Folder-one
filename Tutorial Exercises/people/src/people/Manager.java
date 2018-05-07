package people;

public class Manager extends Person {

    private int basic;
    private int commission;

    public Manager(String managerName, String managerAddress, String managerNINumber, int managerAge, int managerPay) {
        super(managerName, managerAddress, managerNINumber, managerAge, managerPay);
    }
           
   
            
            
            
            public void setBasic(int managerBasic) {
        

        basic = managerBasic;

    }

    public void setCommision(int managerCommission) {

        commission = managerCommission;
    }

    public void calculateSalary() {

        super.pay = basic * commission;
    }
    
    public static void main (String[] args )
    {
        Manager ste = new Manager("Ste", "Celendine", "JS567683s", 36, 6500);
        Person .list();
        Manager joe = new Manager("joe","bobble","js876876",56,3897);
        Person.list();
    }

}
