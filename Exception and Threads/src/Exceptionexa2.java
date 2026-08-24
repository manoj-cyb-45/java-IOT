public class Exceptionexa2 {

    public static void main(String []args) {
        int[] ar={1,2,3};
        try{
            System.out.println(ar[3]);
        }
        catch (Exception e){   // instead of writing exception name we can write just exception
            System.out.println(e);
        }
        int a=11,b=22; // continue because of execution
        int c=a+b;
        System.out.println(c);
    }

}