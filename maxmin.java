//find max min in stack 
import java.util.*;
public class maxmin{
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(5);
        s.push(15);
        System.out.println("Stack: "+s);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : s){
            if(num > max){
                max = num;
            }
            if(num < min){
                min = num;
            }
        }
        System.out.println("Maximum element: "+max);
        System.out.println("Minimum element: "+min);
    }
}
