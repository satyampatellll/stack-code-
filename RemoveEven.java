import java.util.Stack;

public class RemoveEven {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.push(25);

        stack.removeIf(n -> n % 2 == 0);

        System.out.println(stack);
    }
}