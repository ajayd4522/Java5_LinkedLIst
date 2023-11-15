// https://leetcode.com/problems/lfu-cache/description/
// 460. LFU Cache
// Hard
// It is same as LRUCache
// look at this code - error
// not running perfectly giving error
package java5.leetcodeLInkedLIst;

import java.util.HashMap;

public class LFUCache {
    

    // create DLL node
    public class Node {
        private int key;
        private int value;

        private Node prev;
        private Node next;

        public Node (int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Node head = new Node (-1, -1);
    private Node tail = new Node (-1, -1);
    private int capacity;
    // private int counter=0;
    private HashMap <Integer, Node> m = new HashMap <>();
    // private HashMap <Integer, Integer> freq = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if(m.containsKey(key)){
            Node temp = m.get(key);
            int ans = temp.value;

            // maintain recently used pair
            delNode(temp);
            m.remove(key);

            // add again so it is in the first
            addNode(temp);
            m.put(key, head.next);

            // maintain a counter in hashmap
            // freq.put(key, ++counter);
            // counter = 0;


            return ans;

        }
        return -1;

        
    }

    public void delNode(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
        // Node Prev = node.prev;
        // Node Next = node.next;

        // Prev.next = Next;
        // Next.prev = Prev;
    }

    public void addNode (Node newnode){
        // for get adding from head
        if(m.containsKey(newnode.key)){
            newnode.next = head.next;
            newnode.prev = head;

            head.next = newnode;
            newnode.next.prev = newnode;
        }
        // for put adding from tail
        if(!m.containsKey(newnode.key)){
            newnode.prev = tail.prev;
            newnode.next = tail;

            tail.prev = newnode;
            newnode.prev.next = newnode;
        }
        // Node temp = head.next; // create a temp node assign next node of head

        // new_node.next = temp; // pushing new node in between head and temp
        // new_node.prev = head;

        // head.next = new_node; // changing the direction of head and temp
        // temp.prev = new_node;
    }
    
    public void put(int key, int value) {
        if(m.containsKey(key)){
            Node temp = m.get(key);
            m.remove(key);
            delNode(temp);
        }

        if(m.size() == capacity){
            m.remove(tail.prev.key);
            delNode(tail.prev);
        }

        addNode(new Node (key, value));
        m.put(key, tail.prev);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

