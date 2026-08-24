import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThread3  extends Thread{

    int num; // globel varibale
    MultiThread3(int i){ // constructor , is used to assign the passed value to the global variable so we can print it inside the run method
        num=i;
    }
    public void run(){   // we cant pass the parameter to the run method directly
        System.out.println(Thread.currentThread().getName()+" --> "+num);
    }


    public static void main(String []args){

/*
        for (int i=1;i<=10;i++){
            MultiThread3 mt3 =new MultiThread3(i);
            mt3.start();

        }*/
        // the above logic print the correct required output, but it creates multiple thread like for 10 numbers it create 10 different threads
        ExecutorService exe = Executors.newFixedThreadPool(10); //allow to assign the number of threads
        ExecutorService exe1 = Executors.newCachedThreadPool();
        // Executors.newCachedThreadPool() it reuses old threads if they are free if not it create a new thread (but it is not reliable)
        for (int i=1;i<=50;i++){
            MultiThread3 mt3 =new MultiThread3(i);
            exe1.submit(mt3);
        }
        exe1.shutdown();

        // this  provides the scalability and best solution
        // this reuses the threads for repeated number of times
    }

}
