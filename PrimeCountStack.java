import java.util.Stack;

public class PrimeCountStack {

    static boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(2);
        stack.push(4);
        stack.push(7);
        stack.push(10);
        stack.push(13);

        int count = 0;

        for (int n : stack) {
            if (isPrime(n))
                count++;
        }

        System.out.println("Prime Numbers = " + count);
    }
}