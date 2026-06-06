import java.util.Stack;

public class SumStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        int sum = 0;

        for (int num : stack) {
            sum += num;
        }

        System.out.println("Sum of elements = " + sum);
    }
}
