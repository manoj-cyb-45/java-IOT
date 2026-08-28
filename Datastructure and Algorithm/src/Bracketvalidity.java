import java.util.*;

public class Bracketvalidity {
    public static void main(String[] args) {
        Stack<Character> stk = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the string of brackets : ");
        String st = sc.nextLine();

        boolean ans = true;  // assume valid until proven otherwise

        // Loop through all characters (start at 0)
        for(int i = 0; i < st.length(); i++){
            char ch = st.charAt(i);

            // Push opening brackets
            if(ch == '(' || ch == '[' || ch == '{') {
                stk.push(ch);
            }
            // Handle closing parenthesis
            else if(ch == ')') {
                if (stk.isEmpty() || stk.peek() != '(') {
                    ans = false;
                    break; // invalid, stop checking
                } else {
                    stk.pop();
                }
            }
            // Handle closing square bracket
            else if(ch == ']'){
                if(stk.isEmpty() || stk.peek() != '['){
                    ans = false;
                    break;
                } else {
                    stk.pop();
                }
            }
            // Handle closing curly brace
            else if(ch == '}') {
                if (stk.isEmpty() || stk.peek() != '{') {
                    ans = false;
                    break;
                } else {
                    stk.pop();
                }
            }
        }

        // Final check: stack must be empty
        if(!stk.isEmpty()){
            ans = false;
        }

        System.out.print(ans);
    }
}
