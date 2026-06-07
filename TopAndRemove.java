import java.util.Stack;

public class TopAndRemove {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(10);
        stack.push(15);

        System.out.println("Top Element: " + stack.peek());
        stack.pop();

        System.out.println("Stack after removal: " + stack);
    }
}