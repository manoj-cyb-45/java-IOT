import java.util.Scanner;

public class leapyear {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Year:");
        int year=sc.nextInt();
        if (year%400==0 || year%4==0 && year%100!=0){
            System.out.println("Year is Leap year");
        }
        else{
            System.out.print("Year is not Leap year");
        }
    }
}
