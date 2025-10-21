package 算法练习.力扣练习.Hot100;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }

    /**
     * 容量
     */
    private int capacity;

    /**
     * 当前大小
     */
    private int size;
    /**
     * 头结点
     */
    private Node head;
    /**
     * 尾结点
     */
    private Node tail;

    private Map<Integer, Node> mapCache;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
        mapCache = new HashMap<>(capacity + 2);
    }

    public int get(int key) {
        Node node = mapCache.get(key);
        if (node == null){
            return -1;
        }
        toHead(node);
        return node.value;
    }

    public synchronized void put(int key, int value) {
        if (mapCache.get(key) != null){
            Node node = mapCache.get(key);
            node.value = value;
            toHead(node);
            return;
        }
        Node node = new Node();
        node.key = key;
        node.value = value;
        if (size < capacity){
            mapCache.put(key, node);
            size++;
        }else {
            mapCache.remove(tail.pre.key);
            removeLast();
        }
        addHead(node);
        mapCache.put(key, node);
    }

    /**
     * 将一个节点添加到头结点
     */
    private void addHead(Node node){
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    /**
     * 将当前节点添加到头结点
     */
    private void toHead(Node node){
        // 清除当前节点的前后关系
        node.next.pre = node.pre;
        node.pre.next = node.next;

        // 当前节点移到第一位
        addHead(node);
    }


    /**
     * 删除最后当前节点
     */
    private void removeLast(){
        Node lastNode = tail.pre;
        lastNode.pre.next = tail;
        tail.pre = lastNode.pre;
    }


    public static class Node{
        Node next;

        Node pre;

        int key;

        int value;
    }
}
