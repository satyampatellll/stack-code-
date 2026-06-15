//[5 , 2 , c , d , +]
//+  = sum of last two score 
// C = last score remove 
// D = double the last score

import java.util.Stack;

public class BaseballScore {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] scores = {5, 2, -3, 4, 9};
        
        for (int score : scores) {
            if (score == -3) {
                stack.pop();
            } else if (score == -4) {
                stack.push(stack.peek() * 2);
            } else {
                stack.push(score);
            }
        }
        
        int total = 0;
        for (int score : stack) {
            total += score;
        }
        
        System.out.println("Total Score: " + total);
    }
}
