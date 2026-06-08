import java.util.Stack;

public class StackExample {
    public static String encodeWithStack(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        
        // Push the first character to kick things off
        stack.push(text.charAt(0));
        int count = 1;

        for (int i = 1; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            // If it matches the top of the stack, increase the count
            if (!stack.isEmpty() && stack.peek() == currentChar) {
                count++;
            } else {
                // If it's a new character, pop the old one, record it, and push the new one
                result.append(stack.pop()).append(count);
                stack.push(currentChar);
                count = 1; // Reset count for the new character
            }
        }

        // Don't forget to clear the last character remaining on the stack
        if (!stack.isEmpty()) {
            result.append(stack.pop()).append(count);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "aaabb";
        String output = encodeWithStack(input);
        
        System.out.println("Input:  " + input);   // Output: aaabb
        System.out.println("Output: " + output);  // Output: a3b2
    }
}