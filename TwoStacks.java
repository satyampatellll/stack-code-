class TwoStacks {
    int arr[] = new int[10];
    int top1 = -1;
    int top2 = 10;

    void push1(int x) {
        arr[++top1] = x;
    }

    void push2(int x) {
        arr[--top2] = x;
    }

    void display() {
        System.out.println("Stack1 Top: " + arr[top1]);
        System.out.println("Stack2 Top: " + arr[top2]);
    }

    public static void main(String args[]) {
        TwoStacks ts = new TwoStacks();

        ts.push1(10);
        ts.push1(20);

        ts.push2(100);
        ts.push2(200);

        ts.display();
    }
}