package java5.linkedLIst;

public class SLL {

    private Node head;
    private Node tail;
    private int size;

    public SLL () {
        this.size = 0;
    }

    public class Node { // Creating a linked list with value and next node

        private int value;
        private Node next;


        public Node(int value) {
            this.value = value;
        }


        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
        
    }

    // just a simple recursion to check that
    // can we add a new node when it is coming out of recursion call
    // answer is yes
    public void backtrack (){
        Node nhead = this.head;
        backtrackRecurse(nhead);

    }
    private void backtrackRecurse(Node nhead) {
        if(nhead == null){
            return;
        }
        if(nhead.value == 3){
            Node temp = nhead.next;
            Node node = new Node(6);
            nhead.next = node;
            node.next = temp;
        }
        // calling funtion again
        backtrackRecurse(nhead.next);
        
    }



    // removing duplicates from singly linked list
    // https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    // 83. Remove Duplicates from Sorted List
    public Node removeDuplicates (){
        Node temp = head;

        while(temp != null){
            if(temp.next!= null && temp.value == temp.next.value){
                temp.next = temp.next.next;
                size--;
            } else {
                temp = temp.next;
            }
            
        }
        tail =temp;
        tail.next = null;
        return temp;
    }

    // merge two sorted linked list
    // https://leetcode.com/problems/merge-two-sorted-lists/description/
    // 21. Merge Two Sorted Lists
    public static SLL merge(SLL first, SLL second){
        Node f = first.head;
        Node s = second.head;

        SLL ans = new SLL();

        while(f != null && s != null){
            if(f.value < s.value){
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }
        // there might be possibility that one of the linked list is still not copied
        // so for that, check which one is not fully copied
        while(f != null){
            ans.insertLast(f.value);
            f = f.next;
        }

        while(s != null){
            ans.insertLast(s.value);
            s = s.next;
        }
        return ans;
    }

    // https://leetcode.com/problems/merge-two-sorted-lists/submissions/

    public static SLL mergeSort(SLL first, SLL second) {
        Node f = first.head;
        Node s = second.head;

        SLL ans = new SLL();

        while (f != null && s != null) {
            if (f.value < s.value) {
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }

        while (f != null) {
            ans.insertLast(f.value);
            f = f.next;
        }

        while (s != null) {
            ans.insertLast(s.value);
            s = s.next;
        }

        return ans;
    }

    // using bubble sort recursively
    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            Node first = find(col);
            Node second = find(col + 1);

            if (first.value > second.value) {
                // swap
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = find(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    Node prev = find(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        } else {
            bubbleSort(row - 1, 0);
        }
    }

    // recursion reverse of linked list
    public void reverse (){
        reverse(head);
    }
    public void reverse (Node node){
        if(node == tail){
            head = tail;
            return;
        }

        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // in place reversal of linked list
    // https://leetcode.com/problems/reverse-linked-list/
    // Google.Microsoft.Apple.Amazon
    public void reverseInPlace (){
        if(size < 2){
            return;
        }

        Node prev = null;
        Node pres = head;
        Node next = head.next;

        while(pres != null){
            pres.next = prev;
            prev = pres;
            pres = next;
            if(next != null){

                next = next.next;
            }
        }

        head = prev;
    }

    public void insertFirst (int val){  // insertion of node at the first position
        Node node = new Node(val);
        node.next = head;

        head = node;

        if (tail == null){

            tail = head;

        }

        size += 1;


    }

    public void insertLast (int val){ // inserting a node at the end of linked list

        if(tail == null)
        {
            insertFirst(val);
            return;

        }

        Node node = new Node(val);

        tail.next = node;

        tail = node;
        // System.out.println(tail.next);

        size++;


    }

    public void insert (int val, int index){ // here we are inserting node at any position
        if(index == 0){
            insertFirst(val);
            return;
        }

        if(index == size){
            insertLast(val);
            return;
        }

        Node temp = head;

        for (int i = 1; i < index; i++) {
            
            temp = temp.next;

        }

        Node node = new Node (val, temp.next);
        temp.next = node;
    }

    // here we are inserting node by using recursion
    public void insertUsingRec (int val, int index){
        // System.out.println(head.value);
        head = insertRec(val, index, head);
    }

    private Node insertRec (int val, int index, Node node){
        // base condition
        if(index == 0){
            Node n = new Node (val);
            n.next = node;
            size++;
            return n;
        }

        node.next = insertRec(val, --index, node.next);  // check the pre decrement term in index, might be a chance it will create an error
        return node;
    }
    // this is the end of recursion method

    

    public int deleteFirst () { // we are deleting node from first index
        
        int val = head.value;
        head = head.next;

        if (head == null){

            tail = null;
        }

        size--;

        return val;
    }

    public int deleteLast (){
        
        
        if (head == tail){

            return deleteFirst();
            
        }
        
        int val = tail.value;
        tail = traverse(size - 2);
        tail.next = null;

        return val;
    }

    public int delete (int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == size - 1){
            return deleteLast();
        }

        Node prev = traverse( index - 2); // here index is (index - 1) bcoz size is counting from 1 not 0
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }

    public Node find (int value){    // finding the node from the given value
        Node temp = head;

        while(temp == null){
            if(temp.value == value){
                return temp;
            }
            temp = temp.next;

        }

        return null;
    }

    public Node traverse (int index){    // we are traversing to a point just before the tail
        Node temp = head;

        for (int i = 0; i < index ; i++) { // running the loop 1 less bcoz we are already considered the head
            
            temp = temp.next;

        }

        return temp;
    }
    
    public void display (){  // display the linked list

        Node temp = head;

        while (temp != null){
            
            System.out.print(temp.value + " -> ");
            temp = temp.next;

        }

        System.out.println("END");
    }
}
