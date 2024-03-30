public class CustomMap<K, V> {
    private Node<K, V>[] nodes;
    private int size;

    public CustomMap() {
        this.nodes = new Node[20];
        this.size = 0;
    }

    public void put(K key, V value) {
        if (size == nodes.length) {
            resize();
        }

        Node<K, V> newNode = new Node<>(key, value);
        int index = getIndex(key);
        if (nodes[index] != null) {
            Node<K, V> current = nodes[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            current.next = newNode;
        } else {
            nodes[index] = newNode;
        }
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> current = nodes[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public int remove(K key) {
        int index = getIndex(key);
        Node<K, V> current = nodes[index];
        Node<K, V> prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    nodes[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return index;
            }
            prev = current;
            current = current.next;
        }
        return index;
    }

    public boolean containsKey(K key) {
        int index = getIndex((K) key);
        Node<K, V> current = nodes[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (Node<K, V> node : nodes) {
            Node<K, V> current = node;
            while (current != null) {
                if (current.value.equals(value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }


    private int getIndex(K key) {
        return key.hashCode() % nodes.length;
    }

    private void resize() {
        Node<K, V>[] newNodes = new Node[nodes.length * 2];
        for (Node<K, V> node : nodes) {
            Node<K, V> current = node;
            while (current != null) {
                int index = getIndex(current.key);
                if (newNodes[index] == null) {
                    newNodes[index] = new Node<>(current.key, current.value);
                } else {
                    Node<K, V> temp = newNodes[index];
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = new Node<>(current.key, current.value);
                }
                current = current.next;
            }
        }
        nodes = newNodes;
    }
}
