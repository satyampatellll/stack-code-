import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        String infix = "A+B";
        Stack<Character> stack = new Stack<>();
        String postfix = "";

        for(char ch : infix.toCharArray()) {
            if(Character.isLetterOrDigit(ch))
                postfix += ch;
            else
                stack.push(ch);
        }

        while(!stack.isEmpty())
            postfix += stack.pop();

        System.out.println("Postfix = " + postfix);
    }
}