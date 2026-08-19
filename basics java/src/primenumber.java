import java.util.Scanner;
public class primenumber {
   static int faccount(int num){
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
       return (count);
   }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number:");
        int num=sc.nextInt();
        int fc=faccount(num);
        if (fc==2)
        System.out.println("Number is prime");
        else
            System.out.println("Number Is not Prime");
    }
}
