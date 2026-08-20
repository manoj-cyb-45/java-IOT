/*
- binding the private members by binding with public members .
- by using public member we can access private members from anywhere this is called as encapsulation

-----------------------------------------------------------------------------------------------------------------------
- "this" keywords points to current class object reference // it indicates global so it is used for professional coding
- "super" keyword points to super class object reference
- "this()" it executes current class constructor based on parameter
- "super()" it executes super class constructor based on parameter
-----------------------------------------------------------------------------------------------------------------------
- setters :- it helps to set a value to the global private members using public method
- getters :- it helps to get a value to the global private members using public method

-----------------------------------------------------------------------------------------------------------------------
 */
class student{
    private void perDet(){
        System.out.println("Contact number: 1234567890");
    }
    public void stuDet(){
        perDet();
        System.out.println("Name: Manoj");
        System.out.println("Addreess : channi");
    }
}
class Employyee{
    private int eid;
    private  int esal;

    public int getEsal() {
        return esal;
    }

    public void setEsal(int esal) {
        this.esal = esal;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }
}

public class encapsulationex {
    public static void main(String[]args){
        student stu=new student();
        stu.stuDet();
        //stu.perDet();
        //cant call because it is private method

        Employyee emp = new Employyee();
        emp.setEid(101);
        emp.setEsal(960000);
        int eid=emp.getEid();
        int esal=emp.getEsal();
        System.out.println(eid);
        System.out.println(esal);
    }

}
