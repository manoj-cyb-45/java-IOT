import java.util.Scanner;

interface Switch{           // interface is a collection of abstract methods
    //100% abstarction
    void on(); // by default public and abstract
    void off();
}
class fan implements Switch{     //use implemets to abstarct class and for normal class use extends
    @Override
    public void on() {
        System.out.println("Fan is on");
    }

    @Override
    public void off() {
        System.out.println("Fan is off");
    }
}

class light implements Switch{

    @Override
    public void on() {
        System.out.println("Light is on");
    }

    @Override
    public void off() {
        System.out.println("Light is off");
    }
}
class both implements Switch{
    @Override
    public void on() {
        System.out.println("Both are on");
    }

    @Override
    public void off() {
        System.out.println("Both are off");
    }
}

public class interfaceex {
    Switch press(char op) {

        if (op == 'f')
            return new fan();
         else if (op == 'l')
            return new light();
         else if (op == 'b')
            return new both();
         else
            return null;

    }
    public static void main(String[] args) {
        //Switch ss = new fan(); // assign subclass object to super class reference variable
      Scanner sc=new Scanner(System.in);
      System.out.print("Enter your choice (f for fan, l for light, b for both): ");
      char choice = sc.next().charAt(0);
      interfaceex ab=new interfaceex();
      Switch option=ab.press(choice);
      System.out.print("Enter your choice (o for on and f for off): ");
      char opt = sc.next().charAt(0);
      if (opt=='o')
      option.on();
      else if (opt=='f')
      option.off();
      else
        System.out.println("Invalid choice");
    }
}
