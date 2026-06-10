import java.util.Stack;

public class CountOdd {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(11);
        stack.push(20);
        stack.push(33);
        stack.push(40);
        stack.push(55);

        int count = 0;

        for(int n : stack) {
            if(n % 2 != 0)
                count++;
        }

        System.out.println("Odd Numbers = " + count);
    }
}