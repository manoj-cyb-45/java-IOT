import java.util.Scanner;

public class nestedloops {
    void q1() {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.println(i + " " + j);
            }
            System.out.println("-------");
        }
    }
    /*
    1 1
    1 2
    1 3
    -------
    2 1
    2 2
    2 3
    -------
    3 1
    3 2
    3 3
    -------
    */

    void q2(){
        for (int i=1;i<=5;i++){
            for(int j=1;j<=5;j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    /*
    11111
    22222
    33333
    44444
    55555
    */
    void q3(){
        for (int i=1;i<=5;i++){
            for(int j=1;j<=5;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    /*
    12345
    12345
    12345
    12345
    12345
     */
    void q4(){
        for (int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    /*
    1
    22
    333
    4444
    55555
    */

    void q5(){
        for (int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    /*
    1
    12
    123
    1234
    12345
     */
    void q6(){
        for (int i=5;i>=1;i-=2){
            for(int j=i;j>=1;j--){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    /*
    55555
    333
    1
     */
    void q7(){
        for (int i=1;i<=5;i++){
            for(int j=1;j<=5;j++){
                if(i%2==0)
                     System.out.print("@");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
    }
    /*
    #####
    @@@@@
    #####
    @@@@@
    #####
     */
    void q8(){
        for (int i=1;i<=5;i++){
            for(int j=1;j<=5;j++){
                if(j%2==0)
                    System.out.print("@");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
    }
    /*
    #@#@#
    #@#@#
    #@#@#
    #@#@#
    #@#@#
     */
    void q9(){
        int k=1;
        for (int i=1;i<=4;i++){
            for(int j=1;j<=i;j++){
                System.out.print(k);
                k++;
            }
            System.out.println();
        }
    }
    /*
    1
    23
    456
    78910
     */
    void q10(){
        for (int i=1;i<=5;i++){
            for(int j=1;j<=5;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    /*
     *****
     *****
     *****
     *****
     *****
     */
    void q11(){
        for (int i=1;i<=5;i++){
            for(int j=1;j<=5;j++){
                if(i==1||i==5||j==1||j==5)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    /*
     *****
     *   *
     *   *
     *   *
     *****
     */

    void q12(){
        for (int i=1;i<=5;i++){
            for(int j=1;j<=5;j++){
                if(i==j)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    /*
     *
      *
       *
        *
         *
     */
    void q13(){
        int k=5;
        for (int i=1;i<=5;i++){
            for(int j=1;j<=5;j++){
                if(k==j){
                    System.out.print("*");
                    k--;}
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    /*
         *
        *
       *
      *
     *
     */

    void q14(){
        int sp=2;
        for (int i=1;i<=5;i+=2)
        {
            for (int s=1;s<=sp;s++)
                System.out.print(" ");
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
            sp--;
        }
    }

    /*
       *
      ***
     *****
     */
    public static void main(String[] args){
        nestedloops a =new nestedloops();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter choice (1–13): ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                a.q1();
                break;
            case 2:
                a.q2();
                break;
            case 3:
                a.q3();
                break;
            case 4:
                a.q4();
                break;
            case 5:
                a.q5();
                break;
            case 6:
                a.q6();
                break;
            case 7:
                a.q7();
                break;
            case 8:
                a.q8();
                break;
            case 9:
                a.q9();
                break;
            case 10:
                a.q10();
                break;
            case 11:
                a.q11();
                break;
            case 12:
                a.q12();
                break;
            case 13:
                a.q13();
                break;
            case 14:
                a.q14();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
