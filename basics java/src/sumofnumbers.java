import java.util.Scanner;

public class sumofnumbers {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number:");
        int num=sc.nextInt();
        int sum= num*(num+1)/2;
        System.out.println(sum);


        int sum1=0;
        for(int i=1;i<=num;i++){
            sum1+=i;
        }
        System.out.println(sum1);
    }
}
