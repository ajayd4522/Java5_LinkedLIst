// https://leetcode.com/problems/reverse-linked-list-ii/
// 92. Reverse Linked List II
// Google.Microsoft.Facebook
package java5.leetcode;

public class ReverseLinkedLIstII {

    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }

        ListNode current = head;
        ListNode previous = null;

        // skip the node till you reach left - 1 node
        for (int i = 0; current != null && i < left - 1; i++) {
            previous = current;
            current = current.next;
        }

        ListNode last = previous;
        ListNode newEnd = current;

        // reverse the linked list
        for (int i = 0; current != null && i < right - left + 1; i++) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        if(last != null){
            last.next = previous;
        } else {
            head = previous;
        }

        newEnd.next = current;
        return head;
    }

}
