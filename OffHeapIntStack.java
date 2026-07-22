import java.nio.ByteBuffer;

public class OffHeapIntStack {
    private final ByteBuffer buffer;
    private int top = -1;
    private final int capacity;

    public OffHeapIntStack(int capacity) {
        this.capacity = capacity;
        // Allocates direct memory off the JVM heap
        this.buffer = ByteBuffer.allocateDirect(capacity * Integer.BYTES);
    }

    public void push(int value) {
        if (top == capacity - 1) {
            throw new RuntimeException("Off-Heap Stack Overflow");
        }
        top++;
        buffer.putInt(top * Integer.BYTES, value);
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Off-Heap Stack Underflow");
        }
        int value = buffer.getInt(top * Integer.BYTES);
        top--;
        return value;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        OffHeapIntStack stack = new OffHeapIntStack(100);
        stack.push(1001);
        stack.push(2002);
        System.out.println("Popped off-heap value: " + stack.pop()); // 2002
    }
}