import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class TransactionalState<K, V> {
    private Map<K, V> currentState = new HashMap<>();
    private final Deque<Map<K, V>> history = new ArrayDeque<>();

    public void beginTransaction() {
        // Push a copy of current state onto history stack
        history.push(new HashMap<>(currentState));
    }

    public void put(K key, V value) {
        currentState.put(key, value);
    }

    public V get(K key) {
        return currentState.get(key);
    }

    public void commit() {
        if (history.isEmpty()) throw new IllegalStateException("No active transaction");
        history.pop(); // Drop backup snapshot, keeping new state permanent
    }

    public void rollback() {
        if (history.isEmpty()) throw new IllegalStateException("No active transaction");
        currentState = history.pop(); // Revert to snapshot
    }

    public static void main(String[] args) {
        TransactionalState<String, Integer> db = new TransactionalState<>();
        db.put("balance", 100);

        db.beginTransaction();
        db.put("balance", 500);
        System.out.println("In transaction balance: " + db.get("balance")); // 500

        db.rollback();
        System.out.println("Post rollback balance: " + db.get("balance"));  // 100
    }
}