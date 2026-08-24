//multiple catch block example


public class Exceptionexa4 {
    public static void main(String []args) {
        int[] ar={1,2,3};
        try{
            System.out.println(ar[3]);
            System.out.println(12/0);
        }
        catch (ArrayIndexOutOfBoundsException e){ // only this will get executed and moved to line after all catch block
            System.out.println(e);
        }
        catch (ArithmeticException e){
            System.out.println(e);
        }

        int a=11,b=22; // continue  execution
        int c=a+b;
        System.out.println(c);
    }

}

