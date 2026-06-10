import java.util.Stack;

public class DuplicateElements {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        Stack<Integer> result = new Stack<>();

        for(int n : stack) {
            result.push(n);
            result.push(n);
        }

        System.out.println(result);
    }
}