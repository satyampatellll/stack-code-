import java.util.Stack;

public class DecimalToHex {
    public static void main(String[] args) {
        int num = 255;
        Stack<Character> stack = new Stack<>();

        char hex[] = {
            '0','1','2','3','4','5','6','7',
            '8','9','A','B','C','D','E','F'
        };

        while(num > 0) {
            stack.push(hex[num % 16]);
            num /= 16;
        }

        System.out.print("Hexadecimal = ");

        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}