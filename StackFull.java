public class StackFull {
    static int max = 3;
    static int top = -1;
    static int[] stack = new int[max];

    public static void main(String[] args) {
        push(10);
        push(20);
        push(30);

        if (top == max - 1)
            System.out.println("Stack is Full");
    }

    static void push(int data) {
        stack[++top] = data;
    }
}