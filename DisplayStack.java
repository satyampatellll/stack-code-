import java.util.Stack;

public class DisplayStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);

        System.out.println("Elements in Stack:");

        for (Integer item : stack) {
            System.out.println(item);
        }
    }
}