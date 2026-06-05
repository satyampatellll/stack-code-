import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        String exp = "{[()]}";
        Stack<Character> stack = new Stack<>();
        boolean balanced = true;

        for (char ch : exp.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    balanced = false;
                    break;
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            balanced = false;
        }

        if (balanced)
            System.out.println("Expression is Balanced");
        else
            System.out.println("Expression is Not Balanced");
    }
}