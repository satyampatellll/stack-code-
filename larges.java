import java.util.Stack;

public class larges {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(15);
        stack.push(50);
        stack.push(25);
        stack.push(80);
        stack.push(40);

        int max = stack.peek();

        for (Integer num : stack) {
            if (num > max) {
                max = num;
            }
        }

        System.out.println("Largest Element: " + max);
    }
}