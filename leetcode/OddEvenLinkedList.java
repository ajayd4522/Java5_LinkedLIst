// https://leetcode.com/problems/odd-even-linked-list/description/
// 328. Odd Even Linked List
package java5.leetcode;

public class OddEvenLinkedList {
    public  class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {
        // base condition
        if(head == null || head.next == null){
            return head;
        }

        // creating some pointers
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = even;

        // running a loop until even reaches till the end
        while(even != null && even.next != null){
            // changing the next node linkage
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenhead;
        return head;
    }
}
