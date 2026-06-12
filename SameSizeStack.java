import java.util.Stack;

public class SameSizeStack {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        s1.push(1);
        s1.push(2);
        s1.push(3);

        s2.push(10);
        s2.push(20);
        s2.push(30);

        if(s1.size() == s2.size())
            System.out.println("Both stacks have same size");
        else
            System.out.println("Sizes are different");
    }
}
