import java.util.Scanner;
public class lcm {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1st number:");
        int num1 = sc.nextInt();
        System.out.print("Enter 2st number:");
        int num2 = sc.nextInt();
        int max=Math.max(num1,num2);
        int ans=max;
        for(int i=max;i<=num1*num2;i++){
            if(i%num1==0 && i%num2==0){
                ans=i;
                break;
            }
        }
        System.out.println("LCM of is: " + ans);
    }
}
