import java.util.HashMap;
import java.util.PriorityQueue;

public class PQMapHybrid<K, V> {

    // Private members

    private PriorityQueue<V> queue;
    private HashMap<K, V> map;

    // Public members

    public PQMapHybrid() {
        queue = new PriorityQueue<V>();
        map = new HashMap<K, V>();
    }

    // TODO: ?
    public void clear() {
        queue.clear();
        map.clear();
    }

    // O(log n) + O(1) = O(log n)
    public void offer(K key, V value) {
        queue.offer(value);
        // This will update the entry if the key already exists.
        map.put(key, value);
    }

    // O(1)
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // O(log n)
    public V poll() {
        return queue.poll();
    }

    public V remove(K key) {
        return map.remove(key);
    }

    // O(1)
    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    // O(1) - returns null if not found.
    public V get(K key) {
        return map.get(key);
    }

    public PriorityQueue<V> getQueue() {
        return queue;
    }
}
