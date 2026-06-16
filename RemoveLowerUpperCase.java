//remove lower and upper case letters from a string
import java.util.Stack;

class RemoveLowerUpperCase{
    static void performOps(String str){
        Stack<Character> stack = new Stack<>();
        char ch[] = str.toCharArray();
        int i=0;

        for(char c: ch){
            stack.push(c);
            if(i > 1){
                if(stack.peek() == Character.toUpperCase(c)){
                    stack.pop();
                    stack.pop();
                }
            }
            i++;
        }

        System.out.println(stack.toString());
    }
    public static void main(String[] args){
        String str = "LeEeetcode";

        performOps(str);
    }

}

