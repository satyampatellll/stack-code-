import java.util.Stack;

public class FrequencyInStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(10);
        stack.push(30);
        stack.push(10);

        int count = 0;

        for(int num : stack) {
            if(num == 10)
                count++;
        }

        System.out.println("Frequency of 10 = " + count);
    }
}