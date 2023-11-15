package java5.linkedLIst;

public class CLL {

    private Node head;
    private Node tail;

    
    
    public CLL() {
        this.head = null;
        this.tail = null;
    }



    public class Node { // creating circular linked list node
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        
    }

    public void insert(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
        // System.out.println(node.val);
    }

    public void display (){
        if(head == null){
            return;
        }

        Node node = head;

        do {
            System.out.print(node.val + " -> ");
            node = node.next;
        } while (node != head);
        System.out.println("HEAD");

    }

    public void delete (int val){
        if(head == null){
            System.out.println("Empty List, insert it first");
        }
        Node node = head;
        if(node.val == val){
            tail.next = node.next;
            head = node.next;
        }

        do{
            Node n = node.next;
            if(n.val == val){
                node.next = n.next;
                break;
            }
            node = node.next;

        } while(node != head);
    }
}
