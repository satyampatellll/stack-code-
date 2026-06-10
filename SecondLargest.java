import java.util.Stack;

public class SecondLargest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(50);
        stack.push(30);
        stack.push(40);

        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int num : stack) {
            if(num > largest) {
                second = largest;
                largest = num;
            } else if(num > second && num != largest) {
                second = num;
            }
        }

        System.out.println("Second Largest = " + second);
    }
}