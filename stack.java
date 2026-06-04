
//count the elements in a stack without using size() method
import java.util.*;
public class stack{
    public static int countElements(Stack<Integer> s){
        int count = 0;
        Stack<Integer> temp = new Stack<>();
        while(!s.isEmpty()){
            temp.push(s.pop());
            count++;
        }
        while(!temp.isEmpty()){
            s.push(temp.pop());
        }
        return count;
    }
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println("Stack: "+s);
        System.out.println("Number of elements in stack: "+countElements(s));
    }
}