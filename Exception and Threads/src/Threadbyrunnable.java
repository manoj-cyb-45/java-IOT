public class Threadbyrunnable  implements Runnable{
    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            System.out.println(i);
        }
        System.out.println("------------");

    }

    public static  void main(String[]args){
        Threadbyrunnable mt =new Threadbyrunnable();
        Thread t1=new Thread(mt);   // pass the class object to the Thread class as parameter
        t1.start();
    }
}
