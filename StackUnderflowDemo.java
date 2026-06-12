public class StackUnderflowDemo {
    static int top = -1;

    static void pop() {
        if(top == -1)
            System.out.println("Stack Underflow");
    }

    public static void main(String[] args) {
        pop();
    }
}