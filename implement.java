// Stack implementation using Java's built-in Stack class
import java.util.*;
public class implement{
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        System.out.println("Initial stack: "+s);
        System.out.println("Popped element: "+s.pop());
        System.out.println("Stack after pop: "+s);
        System.out.println("Top element: "+s.peek());
        System.out.println("Stack is empty: "+s.isEmpty());
        System.out.println("Stack size: "+s.size());
        while(!s.isEmpty()){
            System.out.println("Popped element: "+s.pop());
        }
    }
}
