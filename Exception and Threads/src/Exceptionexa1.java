
public class Exceptionexa1 {
    public static void main(String []args){
        System.out.println(12/2); // no error
        System.out.println(12/0); // error occurs
        //runtime expection (ArithmeticException)

        int a=11,b=22; // no output because of execution stops in the previous error
        int c=a+b;
        System.out.println(c);

        // to come over this problem we have a different methods like try catch and finally methods
        //try : it will check for the error and trow the error if exist
        // catch : will catch thrown error and perform the instruction
        // * after the error occur the code continue to execute normally
        // finally is the block where it will executed even when try catch works or skipped

        /*
        TYPES
        1. ArithmeticException
        2. ArrayIndexOutOfBoundsException
        3. NullPointerException
         */
    }
}
