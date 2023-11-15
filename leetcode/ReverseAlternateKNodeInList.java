// https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
// this is also similar previous one
// reverse k group in linked list

package java5.leetcode;

public class ReverseAlternateKNodeInList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if(k <= 1 && head == null && head.next == null){
            return head;
        }

        ListNode current = head;
        ListNode previous = null;

        while(current != null){
            ListNode last = previous;
            ListNode newEnd = current;

            // reverse the linked list
            for (int i = 0; current != null && i < k; i++) {
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            // understand this carefully
            if(last != null){
                last.next = previous;
            } else {
                head = previous;
            }

            newEnd.next = current;
            // skip k nodes
            for (int i = 0; i < k; i++) {
                previous = current;
                current = current.next;
            }

        }
        return head;
    }
}
