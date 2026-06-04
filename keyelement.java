//find the key elelment in an array
import java.util.*;
public class keyelement{
    public static int findKeyElement(int[] arr, int key){
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<arr.length; i++){
            while(!s.isEmpty() && s.peek() < arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                s.push(arr[i]);
            } else if(s.peek() == arr[i]){
                return arr[i];
            } else {
                s.push(arr[i]);
            }
        }
        return -1; // return -1 if no key element is found
    }
    public static void main(String[] args){
        int[] arr = {3, 5, 2, 7, 5, 8};
        int key = 5;
        int result = findKeyElement(arr, key);
        if(result != -1){
            System.out.println("Key element found: "+result);
        } else {
            System.out.println("Key element not found");
        }
    }
}
