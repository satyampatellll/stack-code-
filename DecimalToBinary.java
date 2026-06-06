import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        int number = 13;
        Stack<Integer> stack = new Stack<>();

        while (number > 0) {
            stack.push(number % 2);
            number /= 2;
        }

        System.out.print("Binary = ");

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
