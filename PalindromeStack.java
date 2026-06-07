import java.util.Stack;

public class PalindromeStack {
    public static void main(String[] args) {
        String str = "MADAM";
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        String rev = "";

        while (!stack.isEmpty()) {
            rev += stack.pop();
        }

        if (str.equals(rev))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}