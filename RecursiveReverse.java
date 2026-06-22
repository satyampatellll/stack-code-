import java.util.Stack;

public class RecursiveReverse {

    static void insertBottom(Stack<Integer> s, int x) {
        if(s.isEmpty()) {
            s.push(x);
            return;
        }

        int temp = s.pop();
        insertBottom(s, x);
        s.push(temp);
    }

    static void reverse(Stack<Integer> s) {
        if(s.isEmpty())
            return;

        int x = s.pop();
        reverse(s);
        insertBottom(s, x);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);

        reverse(s);

        System.out.println(s);
    }
}