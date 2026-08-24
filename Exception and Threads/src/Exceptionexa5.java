// nested try catch block for multiple exception testing and handling

public class Exceptionexa5 {
    public static void main(String []args) {
        int[] ar = {1, 2, 3};
        try {
            try {
                System.out.println(ar[3]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
            }
            System.out.println(12 / 0);
        } catch (ArithmeticException e) {
            System.out.println(e);
        }

        int a = 11, b = 22;
        int c = a + b;
        System.out.println(c);
    }
}

