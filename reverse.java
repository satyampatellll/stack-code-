//create a stack of characters and perform basic operations
import java.util.*;
public class reverse{
    public static void main(String[] args){
       String str = "Hello, World!";
       Stack<Character> s = new Stack<>();
       for(char ch : str.toCharArray()){
           s.push(ch);
       }
       while(!s.isEmpty()){
           System.out.print(s.pop());
       }
    }
}

