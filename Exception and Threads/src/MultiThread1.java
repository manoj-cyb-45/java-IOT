//Thread ->  Separate uint of execution
// thread is a built-in class
//it is used to execute the task simultaneously


public class MultiThread1  extends Thread{

    public void run(){
        for(int i=0;i<=10;i++){
            System.out.println(i);
        }System.out.println("---------------------");
    }

    public static void main(String []args){
        MultiThread1 mt1=new MultiThread1();
        mt1.start();   // start method call the run method in the local or in the thread class
        //mt1.start();
        //after the completion of task the thread will get distorted automatically we cant call it again
        MultiThread1 mt2=new MultiThread1();
        mt2.start();

        MultiThread1 mt3=new MultiThread1();
        mt3.start();
    }
}
