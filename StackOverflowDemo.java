public class StackOverflowDemo {
    static int MAX = 3;
    static int top = -1;
    static int[] stack = new int[MAX];

    static void push(int data) {
        if(top == MAX - 1)
            System.out.println("Stack Overflow");
        else
            stack[++top] = data;
    }

    public static void main(String[] args) {
        push(10);
        push(20);
        push(30);
        push(40);
    }
}