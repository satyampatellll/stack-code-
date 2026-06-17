//[5 , 2 , c , d , +]
//+  = sum of last two score 
// C = last score remove 
// D = double the last score

import java.util.Stack;

public class BaseballScore {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (String op : new String[]{"5", "2", "C", "D", "+"}) {
            switch (op) {
                case "C" -> stack.pop();
                case "D" -> stack.push(stack.peek() * 2);
                case "+" -> {
                    int last = stack.pop();
                    int secondLast = stack.peek();
                    stack.push(last);
                    stack.push(last + secondLast);
                }
                default -> stack.push(Integer.valueOf(op));
            }
        }
        int total = 0;
        for (int score : stack) {
            total += score;
        }
        System.out.println("Total Score: " + total);
    }
}
