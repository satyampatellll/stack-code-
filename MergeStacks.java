import java.util.Stack;

public class MergeStacks {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        stack1.push(1);
        stack1.push(2);

        stack2.push(3);
        stack2.push(4);

        stack1.addAll(stack2);

        System.out.println("Merged Stack: " + stack1);
    }
}