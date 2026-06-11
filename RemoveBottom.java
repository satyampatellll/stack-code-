import java.util.Stack;

public class RemoveBottom {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        stack.remove(0);

        System.out.println(stack);
    }
}