import java.util.Arrays;

public class KStacks {
    private final int[] arr;   // Holds actual data
    private final int[] top;   // Stores top indices for each stack
    private final int[] next;  // Stores next entry index or free list pointers
    private int freeTop;       // Points to top of the free list

    public KStacks(int numStacks, int capacity) {
        arr = new int[capacity];
        top = new int[numStacks];
        next = new int[capacity];

        // All stacks are initially empty (-1)
        Arrays.fill(top, -1);

        // Initialize free list: 0 -> 1 -> 2 ... -> capacity-1 -> -1
        freeTop = 0;
        for (int i = 0; i < capacity - 1; i++) {
            next[i] = i + 1;
        }
        next[capacity - 1] = -1; // End of free list
    }

    public void push(int stackNum, int item) {
        if (freeTop == -1) {
            throw new RuntimeException("Stack Overflow: No free space left across all stacks");
        }

        int i = freeTop;        // Get index from free list
        freeTop = next[i];      // Advance free list top
        next[i] = top[stackNum]; // Link new node to previous top of this stack
        top[stackNum] = i;      // Update top of this stack
        arr[i] = item;          // Insert data
    }

    public int pop(int stackNum) {
        if (top[stackNum] == -1) {
            throw new RuntimeException("Stack Underflow on stack " + stackNum);
        }

        int i = top[stackNum];   // Get index of top element
        top[stackNum] = next[i]; // Update top pointer to next element in stack
        next[i] = freeTop;       // Return freed slot to free list
        freeTop = i;

        return arr[i];
    }

    public static void main(String[] args) {
        KStacks ks = new KStacks(3, 10);

        ks.push(0, 15);
        ks.push(0, 45);
        ks.push(2, 100);
        ks.push(1, 30);

        System.out.println("Popped from stack 0: " + ks.pop(0)); // 45
        System.out.println("Popped from stack 2: " + ks.pop(2)); // 100
    }
}