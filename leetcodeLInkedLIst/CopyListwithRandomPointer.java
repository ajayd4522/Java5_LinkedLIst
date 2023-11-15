// https://leetcode.com/problems/copy-list-with-random-pointer/description/
// 138. Copy List with Random Pointer

// there are two methods to solve this question
// 1.HashMap , 2.Interweaving
// 2 one is more optimized than 1 one.

package java5.leetcodeLInkedLIst;
import java.util.HashMap;
public class CopyListwithRandomPointer {
    
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node (int val, Node next){
            this.val = val;
            this.next = next;
            this.random = null;
        }
    }
    /* 
    // First Method
    // HashMap method
    // TC(O(N)), SC(O(N))
    // extra space is for inserting in hashmap at each node
    public Node copyRandomList(Node head) {
        // base condition
        if(head == null){
            return head;
        }

        // create Hashmap
        HashMap<Node, Node> oldToNew = new HashMap<>();

        Node curr = head;
        // while traversing in the list map it at each node
        while(curr != null){
            oldToNew.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head; // moving back the curr pointer to the head

        // again traversing so the new nodes get their next and random pointer
        // by using key to point next and random pointer
        while(curr != null){
            oldToNew.get(curr).next = oldToNew.get(curr.next);
            oldToNew.get(curr).random = oldToNew.get(curr.random);
            curr = curr.next;

        }

        return oldToNew.get(head); // it will return the value which is new LL head

      } */



    // Second Method
    // Interweaving method
    // TC(O(N)), SC(O(1))
    // space complexity is constant bcoz we are not storing anything other than the new LL
    // just changing directions
    public Node copyRandomList(Node head) {
        // Here we need to traverse 3 times, bocz we are manipulating the existing LL
        // thats why need to traverse again and again

        // base condition
        if(head == null){
            return head;
        }

        Node curr = head;
        // 1 traversing
        while(curr != null){
            Node new_node = new Node(curr.val, curr.next);
            curr.next = new_node;

            curr = new_node.next;

        } // traversed at each old node to create a corresponding new node

        curr = head;

        // 2 traversing
        // this time we will be considering the random pointer
        while(curr != null){
            if(curr.random != null){

                curr.next.random = curr.random.next;
            }
            curr = curr.next == null ? null : curr.next.next;
            // curr = curr.next; // this will generate error, possibillity is that next node is null
        }

        // 3 traversing
        // this will serperate new nodes from old nodes
        // for this we have to create some pointers
        // now, pattern is same as we are doing in
        // Seperate odd and even indices, like 1 node(old node) is in odd index and 2 node(new node) is in even index

        Node new_head = head.next;
        Node curr_old = head;
        Node curr_new = new_head;

        while(curr_old != null){
            curr_old.next = curr_old.next.next;
            curr_new.next = curr_new.next != null ? curr_new.next.next : null;
            curr_old = curr_old.next;
            curr_new = curr_new.next;
        }

        return new_head;
      }
}
