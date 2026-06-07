import java.util.Stack;

public class DeleteMiddle {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.remove(stack.size() / 2);

        System.out.println(stack);
    }
}
