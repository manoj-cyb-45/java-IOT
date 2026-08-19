import java.util.Scanner;
public class factorialcount {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        long num=sc.nextInt();
        int count=0;
         for (int n=1;n*n<=num ; n++){
            if (num % n == 0 ) {
                if (n * n == num) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        System.out.print(count);
    }
}
