public class MultiThread2 {
    public void run(){
        for(int i=0;i<=10;i++){
            System.out.println(i);
        }System.out.println("---------------------");
    }

    public static void main(String []args) {
        MultiThread1 mt1 = new MultiThread1();
        mt1.start();   // it takes more time to get execute
        System.out.println("One");
        System.out.println("Two"); //main method is also a thread called main so these will get executed 1st before the mt1 thread

    }
}
