public class Exceptionexa3 {
    public static void main(String []args) {
        try{
            System.out.println(12/0);
        }
        catch (ArithmeticException e){
            System.out.println(e);
        }
        int a=11,b=22; // continue because of execution
        int c=a+b;
        System.out.println(c);
    }
}
