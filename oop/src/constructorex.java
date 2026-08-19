
class Employee{
        int eid; // instance variable or global variable
        String ename;
        void printEmpDet() {
            System.out.println(eid);
            System.out.println(ename);
        }
    }
    class Student{
        int sid;
        String sname;

        Student(int id, String name) {
            sid = id;
            sname = name;
        }
        void printStuDet() {
            System.out.println(sid);
            System.out.println(sname);

        }
    }
    class Demo{
        Demo(){
            System.out.println("Default Constructor");
        }
        Demo(int num){
            this();// this call the default constructor
            // this() it executes current class constructor based on parameter
            System.out.println("Parameterized Constructor: " + num);
        }
    }
    public class constructorex {
        public static void main(String[] args) {
            Employee emp = new Employee();
            emp.eid = 101;
            emp.ename = "John Doe";
            emp.printEmpDet();

            Student stu = new Student(201,"jane Smith");
            //stu.sid = 201;
            //stu.sname = "Jane Smith";
            stu.printStuDet();
            // by using constructor we can pass multiple parameter to the constructor
            // without wrting multiple line of assignemnt using the object


            //Demo d2 = new Demo(); //object needed but no need of method call
            Demo d1 = new Demo(42); // or new Demo();
            // object needed but no need of method call
        }
}
