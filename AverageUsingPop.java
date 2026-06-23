import java.util.Stack;

public class AverageUsingPop {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        int sum = 0;
        int count = stack.size();

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println("Average = " + (sum / count));
    }
}