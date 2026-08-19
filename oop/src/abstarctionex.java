//abstract  is the keyword
//we can use abstract keyword to the class and method
//inside abstract class we can create both abstract and concrete methods
//we have to override abstract class methods if we are extending the abstract class
//we cant create object for abstract class



abstract class Gmail {
    abstract void inbox(); // abstract method

    abstract void sentitems(); // abstract method;

    void demo() { // concrete method
        System.out.println("This is a concrete method");
    }
}
    class Victor extends Gmail{
        @Override
        void inbox() {
            System.out.println("This is  Victor's inbox ");
        }

        @Override
        void sentitems() {
            System.out.println("This is Victor's sentitems");
        }
    }
    class jerry extends Gmail{
        @Override
        void inbox() {
            System.out.println("This is  jerry's inbox ");
        }

        @Override
        void sentitems() {
            System.out.println("This is jerry's sentitems");
        }
    }

public class abstarctionex {
    public static void main(String[] args) {
        Victor vv=new Victor();
        vv.inbox();
        vv.sentitems();
        vv.demo(); // this executes concrete method in Gmail class (parent class)
        jerry jj=new jerry();
        jj.inbox();
        jj.sentitems();
        jj.demo(); // this executes concrete method in Gmail class (parent class) since we cant create object for abstract class
        // we can use the concrete method in the abstract class by using the subclass object

    }
}
