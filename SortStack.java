import java.util.Collections;
import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(40);
        stack.push(10);
        stack.push(30);
        stack.push(20);

        Collections.sort(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}