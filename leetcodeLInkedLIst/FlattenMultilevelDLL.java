// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/
// 430. Flatten a Multilevel Doubly Linked List

package java5.leetcodeLInkedLIst;

public class FlattenMultilevelDLL {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        flattenRecursion(head, null);
        return head;
 
    }
    // this is the main function which flatten the multilevel doubly linked list
    // we are using backward recursion (coming out of the stack memory)
    private void flattenRecursion(Node curr, Node end) {
        // base condition
        if(curr == null){ 
            return;
        }

        // call the function again
        flattenRecursion(curr.next, end);

        // this is joining the next node of node having child in the last of child level
        if(curr.next == null && end != null){
            curr.next = end;
            end.prev = curr;
        }

        // coming out of recursion call
        // things to do
        if(curr.child != null){
            end = curr.next;
            curr.next = curr.child;

            flattenRecursion(curr.next, end);

            curr.next.prev = curr;
            curr.child = null;
        }
    }   
}
