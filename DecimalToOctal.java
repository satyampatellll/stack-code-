import java.util.Stack;

public class DecimalToOctal {
    public static void main(String[] args) {
        int num = 65;
        Stack<Integer> stack = new Stack<>();

        while (num > 0) {
            stack.push(num % 8);
            num /= 8;
        }

        System.out.print("Octal = ");

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}