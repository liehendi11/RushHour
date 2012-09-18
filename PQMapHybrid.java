import java.util.HashMap;
import java.util.PriorityQueue;

public class PQMapHybrid<K, V> {

    // Private members

    private PriorityQueue<V> queue;
    private HashMap<K, V> map;

    // Public members

    public PQMapHybrid() {
        queue = new PriorityQueue<V>();
    }

    public void add(K key, V value) {

    }

    public void remove(K key) {
        // Here we do not remove from the priority queue.

        // Remove from the hash map.
        map.remove(key);
    }

}
