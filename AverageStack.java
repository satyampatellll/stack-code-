import java.util.Stack;

public class AverageStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        int sum = 0;

        for(int n : stack) {
            sum += n;
        }

        double avg = (double) sum / stack.size();

        System.out.println("Average = " + avg);
    }
}