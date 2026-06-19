import java.util.Stack;

public class GreaterThan50 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(20);
        stack.push(60);
        stack.push(80);
        stack.push(40);

        int count = 0;

        for(int n : stack) {
            if(n > 50)
                count++;
        }

        System.out.println("Count = " + count);
    }
}