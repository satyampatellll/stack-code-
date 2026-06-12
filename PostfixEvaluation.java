import java.util.Stack;

public class PostfixEvaluation {
    public static void main(String[] args) {
        String exp = "23*5+";
        Stack<Integer> stack = new Stack<>();

        for(char ch : exp.toCharArray()) {
            if(Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int b = stack.pop();
                int a = stack.pop();

                switch(ch) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }

        System.out.println("Result = " + stack.pop());
    }
}