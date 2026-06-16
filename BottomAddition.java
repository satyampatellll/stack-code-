//bottom addition 
import java.util.Scanner;
import java.util.Stack;
public class BottomAddition {
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println("Stack before addition: "+s);
        Scanner var = new Scanner(System.in);
        System.out.print("Enter a number to add at the bottom: ");
        int num = var.nextInt();
        addAtBottom(s, num);
        System.out.println("Stack after addition: "+s);
    }
    public static void addAtBottom(Stack<Integer> s, int num){
        if(s.isEmpty()){
            s.push(num);
            return;
        }
        int top = s.pop();
        addAtBottom(s, num);
        s.push(top);
    }
}
 