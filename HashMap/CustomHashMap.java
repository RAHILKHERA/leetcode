package HashMap;

public class CustomHashMap<K, V> {

    private static final int INITIAL_SIZE = 1 << 4;
    private static final int MAXIMUM_SIZE = 1 << 30;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Entity<K, V>[] hashTable;
    private int size = 0;
    private final float loadFactor;
    private int threshold;

    public CustomHashMap() {
        this(INITIAL_SIZE, DEFAULT_LOAD_FACTOR);
    }

    public CustomHashMap(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    @SuppressWarnings("unchecked")
    public CustomHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0 || loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Invalid capacity or load factor");
        }

        int capacity = getCapacity(initialCapacity);
        this.hashTable = new Entity[capacity];
        this.loadFactor = loadFactor;
        this.threshold = (int) (capacity * loadFactor);
    }

    private final int getCapacity(int capacity) {
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n <= 0) ? 1 : (n >= MAXIMUM_SIZE) ? MAXIMUM_SIZE : n + 1;
    }

    private int getHash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private final int getIndex(K key) {
        return (hashTable.length - 1) & getHash(key);
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int oldCapacity = hashTable.length;
        int newCapacity = getCapacity(oldCapacity * 2);
        Entity<K, V>[] newTable = new Entity[newCapacity];

        for (Entity<K, V> headNode : hashTable) {
            while (headNode != null) {
                Entity<K, V> next = headNode.next;

                int newIndex = (newCapacity - 1) & getHash(headNode.key);
                headNode.next = newTable[newIndex];
                newTable[newIndex] = headNode;

                headNode = next;
            }
        }

        hashTable = newTable;
        threshold = (int) (newCapacity * loadFactor);
    }

    public final boolean isEmpty() {
        return size == 0;
    }

    public final void put(K key, V value) {
        if (key == null) {
            throw new NullPointerException("Null key is not allowed.");
        }

        if (value == null) {
            throw new NullPointerException("Null value is not allowed.");
        }

        if (size + 1 > threshold) {
            resize();
        }

        int index = getIndex(key);
        Entity<K, V> node = hashTable[index];
        if (node == null) {
            node = new Entity<K, V>(key, value);
            hashTable[index] = node;
            size++;
        } else {
            Entity<K, V> previousNode = node;
            while (node != null) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                previousNode = node;
                node = node.next;
            }
            previousNode.next = new Entity<K, V>(key, value);
            size++;
        }
    }

    public final V get(K key) {
        if (key == null) {
            throw new NullPointerException("Cannot fetch value for null key.");
        }
        int index = getIndex(key);
        Entity<K, V> node = hashTable[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public final boolean remove(K key) {
        if (key == null) {
            throw new NullPointerException("Cannot remove value for null key.");
        }

        int index = getIndex(key);
        Entity<K, V> node = hashTable[index];
        if (node == null) {
            return false;
        }

        Entity<K, V> dummyNode = new Entity<K, V>(null, null);
        dummyNode.next = node;
        Entity<K, V> previousNode = dummyNode;
        while (node != null) {

            if (node.key.equals(key)) {
                Entity<K, V> nextNode = node.next;
                previousNode.next = nextNode;
                node.next = null;
                hashTable[index] = dummyNode.next;
                size--;
                return true;
            }
            previousNode = node;
            node = node.next;
        }

        return false;
    }

    public final int getSize() {
        return size;
    }

    private static class Entity<K, V> {

        K key;
        V value;
        Entity<K, V> next;

        Entity(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

}
