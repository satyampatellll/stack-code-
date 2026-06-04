//check if a string is a palindrome using stack
import java.util.*;
public class palindrome{
    public static boolean isPalindrome(String str){
        Stack<Character> s = new Stack<>();
        for(char ch : str.toCharArray()){
            s.push(ch);
        }
        for(char ch : str.toCharArray()){
            if(ch != s.pop()){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String str1 = "madam";
        String str2 = "hello";
        System.out.println(str1+" is palindrome: "+isPalindrome(str1));
        System.out.println(str2+" is palindrome: "+isPalindrome(str2));
    }
}
