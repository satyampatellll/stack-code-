import java.util.Stack;

public class PrintStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        for(String item : stack) {
            System.out.println(item);
        }
    }
}