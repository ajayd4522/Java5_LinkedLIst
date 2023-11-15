package java5.linkedLIst;

public class DLL {

    private Node head;
    
    public class Node { // created a doubly linked list node
        int val;
        Node next;
        Node prev;
        
        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {

            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        
    }

    public void insertFirst (int val){
        Node node = new Node (val);

        node.next = head;
        node.prev = null;

        // first check head before adding node, if it is empty or not
        if(head != null){  // checkig for null pointer exception
            
            head.prev = node;
            
        }
        head = node;
        // System.out.println(node.val);
    }

    public void display (){
        Node node = head;
        Node last = head;

        if(node == null){
            return;
        }

        while(node != null){
            System.out.print(node.val + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");



        System.out.println("Print in reverse");
        while(last != null){
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }

    public void insertLast (int val){
        if(head == null){
            insertFirst(val);
            return;
        }
        Node temp = traverse();

        Node node = new Node(val);

        node.next = null;
        node.prev = temp;
        temp.next = node;


    }

    public Node traverse (){ // here we are traversing till the null and returning the last value just previous to null
        Node node = head;
        Node last = head;

        while(node != null){
            last = node;
            node = node.next;
        }

        return last;
    }

    public void insertAfterIndex (int val, int after){
        if(head == null){
            insertFirst(val);
            return;
        }

        Node temp = search(after);
        if(temp.next == null){
            insertLast(val);
            return;
        }

        Node node = new Node(val);
        node.next = temp.next;
        node.prev = temp;
        temp.next.prev = node;
        temp.next = node;
    }

    public Node search (int index){
        Node temp = head;

        for (int i = 1; i < index; i++) {
        
            temp = temp.next;
            
        }
        return temp;
    }

    public void insertAfterValue (int value, int after){
        if(head == null){
            System.out.println("Empty List");
        }

        Node temp = find(after);
        if(temp == null){
            System.out.println("Does not Exist");
        }
        if(temp.next == null){
            insertLast(value);
            return;
        }

        Node node = new Node(value);

        node.next = temp.next;
        node.prev = temp;
        temp.next.prev = node;
        temp.next = node;


    }

    public Node find (int value){
        Node temp = head;
        while(temp != null){
            if(temp.val == value){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


}
