package 自己玩;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    // 双向链表加上HashMap实现LRU算法

    public class Entry{
        Entry next;
        Entry pre;
        int value;
        public Entry(int value) {
            this.value = value;
        }
        public Entry() {}
    }

    // 容量
    public int capacity;
    // 当前大小
    public int size;
    // 缓存map
    public Map<Integer, Entry> cache;

    // 头结点
    public Entry head;
    // 尾结点
    public Entry tail;

    /**
     * 构造函数，通过
     * @param capacity 容量
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        init();
    }


    public void init(){
        cache = new HashMap<>(capacity + 2);  // 缓存大小为容量+2
        head = new Entry();
        tail = new Entry();
        head.next = tail;
        tail.pre = head;
    }

    // 向双向链表中添加数据
    public synchronized void put(int value){
        if (cache.containsKey(value)){
            // 将用过的元素移动到头结点
            toHead(cache.get(value));
            return;
        }
        // 链表中没有这个元素
        // 容量没有满，添加一个数据到链表头
        if (size < capacity){
            Entry entry = new Entry(value);
            addHead(entry);
            cache.put(value, entry);
            size++;
        }else {
            // 删除双向链表最后的数据
            removeTail();
            // 添加新的数据
            addHead(new Entry(value));
        }
    }

    // 将当前节点移动到头结点
    private void toHead(Entry entry){
        // 从链表中删除当前节点
        removeEntry(entry);
        // 将当前节点添加到头结点
        addHead(entry);
    }

    // 删除一个节点
    private void removeEntry(Entry entry){
        entry.pre.next = entry.next;
        entry.next.pre = entry.pre;
    }

    // 将一个节点添加到头结点
    private void addHead(Entry entry){
        // 当前节点指向第一个元素的节点
        entry.next = head.next;
        entry.pre = head;
        head.next.pre = entry;
        head.next = entry;
    }

    // 删除尾结点
    private void removeTail(){
        // 临时获取最后一个节点
        Entry tailPre = tail.pre;
        // 尾结点指向前一个节点
        tail.pre = tail.pre.pre;
        tail.pre.next = tail;
        // 清除当前最后一个节点的引用
        tailPre.next = null;
        tail.pre = null;
        size--;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put(1);
        printValue(lruCache.head);
        lruCache.put(2);
        printValue(lruCache.head);
        lruCache.put(3);
        printValue(lruCache.head);
        lruCache.put(4);
        printValue(lruCache.head);
        lruCache.put(5);
        printValue(lruCache.head);
        lruCache.put(2);
        printValue(lruCache.head);
        lruCache.put(9);
        printValue(lruCache.head);
    }

    public static void printValue(Entry head){
        Entry next = head.next;
        while (next.next != null){
            System.out.print(next.value + " ");
            next = next.next;
        }
        System.out.println();
    }
}
