import java.util.Stack;

public class CopyStack {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        stack2.addAll(stack1);

        System.out.println("Original Stack: " + stack1);
        System.out.println("Copied Stack: " + stack2);
    }
}
