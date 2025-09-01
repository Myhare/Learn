package 算法练习.力扣练习.剑指Offer;


import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存
 * 双向链表加上map实现
 */
public class LRUCache {

    int size;

    int capacity;

    LRUNode head;

    LRUNode tail;

    Map<Integer, LRUNode> map;

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        System.out.println(lRUCache.get(2));
        lRUCache.put(2, 6);
        System.out.println(lRUCache.get(1));
        lRUCache.put(1, 5);
        lRUCache.put(1, 2);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LRUNode();
        tail = new LRUNode();
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        LRUNode node = map.get(key);
        if (node == null){
            return -1;
        }
        toFirst(node);
        return node.value;
    }

    /**
     * 防止并发put
     * @param key
     * @param value
     */
    public synchronized void put(int key, int value) {
        // 如果是已经存在的node，将这个节点移到最前即可
        if (map.get(key) != null){
            LRUNode lruNode = map.get(key);
            lruNode.value = value;
            toFirst(lruNode);
            return;
        }
        LRUNode newNode = new LRUNode();
        newNode.key = key;
        newNode.value = value;
        newNode.pre = head;
        newNode.next = head.next;

        map.put(key, newNode);

        head.next.pre = newNode;
        head.next = newNode;
        size++;
        if (size > capacity){
            removeLastNode();
        }
    }

    /**
     * 将一个节点移到最前面
     * @param lruNode
     */
    private void toFirst(LRUNode lruNode){
        // 移除原来节点
        lruNode.pre.next = lruNode.next;
        lruNode.next.pre = lruNode.pre;

        // 原节点提到头部
        lruNode.pre = head;
        lruNode.next = head.next;
        head.next.pre = lruNode;
        head.next = lruNode;
    }

    private void removeLastNode(){
        if (size == 0){
            return;
        }
        map.remove(tail.pre.key);
        LRUNode tempNode = tail.pre.pre;
        tempNode.next = tail;
        tail.pre = tempNode;
        size--;
    }

    public static class LRUNode{
        LRUNode pre;

        LRUNode next;

        int key;
        int value;

    }

}
