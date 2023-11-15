// https://leetcode.com/problems/middle-of-the-linked-list/description/
// 876. Middle of the Linked List

package java5.leetcode;

public class MiddleOfTheLInkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        while(f != null && f.next != null){
            f = f.next.next;
            s = s.next;


        }

        return s;
    }
}
