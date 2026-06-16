//remove the outer brackets from a string

import java.util.Stack;

public class RemoveBrackets {
    public static void main(String[] args) {
        String str = "((()))";
        System.out.println(removeOuterBrackets(str));
    }

    public static String removeOuterBrackets(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }
} 
