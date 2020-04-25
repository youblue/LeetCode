# LeetCode146

* Author：Wangshu Zhang
* Version：2020-04-09

# Problem: LRU Cache

# References:
http://www.noteanddata.com/leetcode-146-LRU-Cache-java-solution-note-2.html
https://www.programcreek.com/2013/03/leetcode-lru-cache-java/

Knowledge about LinkedHashMap:
https://www.geeksforgeeks.org/linkedhashmap-class-java-examples/
https://www.geeksforgeeks.org/linkedhashmap-removeeldestentry-method-in-java/

### Code
```Java
class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private int capacity;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75F, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
        this.capacity = capacity;
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```

```Java
// Standard solution
class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int cap = 0;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }
        Node t = map.get(key);
        removeNode(t);
        offerNode(t);
        return t.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node t = map.get(key);
            t.value = value;
            removeNode(t);
            offerNode(t);
        } else {
            if (map.size() >= cap) {
                map.remove(head.key);
                removeNode(head);
            }
            Node node = new Node(key, value);
            offerNode(node);
            map.put(key, node);
        }
    }

    private void removeNode(Node n) {
        if (n.prev != null){
            n.prev.next = n.next;
        } else {
            head = n.next;
        }
        if (n.next != null) {
            n.next.prev = n.prev;
        } else {
            tail = n.prev;
        }
    }

    private void offerNode(Node n) {
        if (tail != null) {
            tail.next = n;
        }
        n.prev = tail;
        n.next = null;
        tail = n;
        if (head == null) {
            head = tail;   
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```
