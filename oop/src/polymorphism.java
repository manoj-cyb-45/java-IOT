/*
 -one can have many forms
 - complietime (method overloading):-name must be same and parameters must be different with in same class
 - runtime (method overloading):-name  and parameters must be same but it must be in different class with inheritance
 -Super keyword :-
 */

class bookDetails{
    void bookDet(){
        System.out.print("book details");
        System.out.print("--------------");
    }
    void bookDet(int rate){
        System.out.print("Book Rate is "+rate);
    }
    void bookDet(String auth){
        System.out.print("Book Author name is "+auth);
    }
}

//this class have same method name with different type of parameters
// this show over-loading
class javaBook extends bookDetails{
    void bookDet(){
        System.out.print(" java book details");
        System.out.print("--------------");
    }
    void bookDet(int rate){
        //super.bookDet(340);
        // this will allow to access the super class method
        System.out.print(" java Book Rate is "+rate);
    }
    void bookDet(String auth){
        System.out.print("java Book Author name is "+auth);
    }
}
//the above class is inherited from the super class and have same named and parametered methods
//this shows over-riding
public class polymorphism {
    public static void main(String[] args) {
        bookDetails jb = new javaBook(); //assigning subclass object to super class ref variable
        jb.bookDet();
        jb.bookDet(340);
        jb.bookDet("Nelson");
    }
}
