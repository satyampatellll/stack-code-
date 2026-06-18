import java.util.Stack;

public class RotateStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        int top = stack.pop();
        stack.insertElementAt(top, 0);

        System.out.println(stack);
    }
}