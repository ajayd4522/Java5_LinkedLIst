// https://leetcode.com/problems/lru-cache/
// 146. LRU Cache
// Medium

package java5.leetcodeLInkedLIst;
import java.util.HashMap;
// 1 First method
// HashMap, LinkedLIst DLL
class LRUCache {
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
    private HashMap <Integer, Node> m = new HashMap <>();

    public LRUCache(int capacity) {
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

            return ans;

        }
        return -1;

        
    }

    public void delNode(Node node){
        Node Prev = node.prev;
        Node Next = node.next;

        Prev.next = Next;
        Next.prev = Prev;
    }

    public void addNode (Node new_node){
        Node temp = head.next; // create a temp node assign next node of head

        new_node.next = temp; // pushing new node in between head and temp
        new_node.prev = head;

        head.next = new_node; // changing the direction of head and temp
        temp.prev = new_node;
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
        m.put(key, head.next);
    }
    /**
    * Your LRUCache object will be instantiated and called as such:
    * LRUCache obj = new LRUCache(capacity);
    * int param_1 = obj.get(key);
    * obj.put(key,value);
    */
}



// 2 Second method
// Array, LinkedList DLL
// size of array depends on key constraints
/*
public class LRUCache {
    class LRUCache {
        class Node{//DLL 
            private int key;
            private int value;
    
            Node prev;
            Node next;
    
            Node(int key, int value){
                this.key= key;
                this.value= value;
            }
        }
    
        private Node[] map;//stores each node metatdata reff w.r.t to key
        private int count, capacity;
        private Node head, tail;
        
        public LRUCache(int capacity) { //all nodes are inserded b/w head and tail node 
            
            this.capacity= capacity;
            count= 0;
            
            map= new Node[10_000+1];//no of nodes //metadata w.r.t. to key 
            
            head= new Node(0,0);
            tail= new Node(0,0);
            
            head.next= tail;
            tail.prev= head;
            
            head.prev= null;
            tail.next= null;
        }
        
        public void deleteNode(Node node){ // deleting the node in LRU cache 
            node.prev.next= node.next;
            node.next.prev= node.prev;       
            
            return;
        }
        
        public void addToHead(Node node){// adding the node in front of head i.e;in LRU cache 
            node.next= head.next;
            node.next.prev= node;
            node.prev= head;
            
            head.next= node;      
            
            return;
        }
        
        public int get(int key) { // O(1)
            
            if( map[key] != null ){ //if node is present in LRU cache 
                
                Node node= map[key];//getting the node metadata 
                
                int nodeVal= node.value;
                
                deleteNode(node);//deleting the node from dll //O(1)
                
                addToHead(node);//adding to the front of head //now visited //O(1)
                
                return nodeVal;//returning the value of the node w.r.t to key 
            }
            else
                return -1;//node not present 
        }
        
        public void put(int key, int value) { // O(1)
            
            if(map[key] != null){//node already exists in LRU cache 
                
                Node node= map[key]; //getting the node metadata
                
                node.value= value;//changing the node value to the current value 
                
                deleteNode(node);//deleting the node  //O(1)
                
                addToHead(node);//adding node in front of head  //O(1)
                
            } else {//node dosent  exists in LRU cache 
                
                Node node= new Node(key,value);
                
                map[key]= node;
                
                if(count < capacity){ //Case 1 //space availabe 
                    count++;
                    addToHead(node);
                } 
                else {//case 2 //space not availabe (capacity full)
                    
                    //deleting the least recently used node, making 1 sapce availabele
                    map[tail.prev.key]= null;
                    deleteNode(tail.prev);
                    
                    //adding the node in front of head
                    addToHead(node);
                }
            }
            
            return;
        }
        
    } */
    
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
