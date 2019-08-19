import java.util.HashMap;

//        运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
//
//        获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
//        写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，
//        它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
//
//        进阶:
//        你是否可以在 O(1) 时间复杂度内完成这两种操作？


class Node {
    public int key, val;
    public Node pre, next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoubleList {
    private Node head, tail;
    private int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public void addFirst(Node x) {
        x.next = head.next;
        x.pre = head;
        head.next.pre = x;
        head.next = x;
        size++;
    }

    public void remove(Node x) {
        x.pre.next = x.next;
        x.next.pre = x.pre;
        size--;
    }

    public Node removeLast() {
        if (tail.pre == head) {
            return null;
        }
        Node last = tail.pre;
        remove(last);
        return last;
    }

    public int size() {
        return size;
    }
}


public class LRUCache_146 {
    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache_146(int capacity) {
        map = new HashMap<>();
        cache = new DoubleList();
        this.cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        put(key, val);
        return val;

    }

    public void put(int key, int value) {
        Node x = new Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(x);
            map.put(key, x);
        } else {
            if (cap == cache.size()) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(x);
            map.put(key, x);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */