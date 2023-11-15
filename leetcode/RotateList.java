// https://leetcode.com/problems/rotate-list/description/
// 61. Rotate List
// FaceBook, Twitter, Google

package java5.leetcode;

public class RotateList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {

        if(k <= 0 || head == null || head.next == null){
            return head;
        }

       // first find last node and length simultaneously
       ListNode last = head;
       int length = 1;
       while(last.next != null){
            last = last.next;
            length++;
       }

       last.next = head;
       int rotations = k % length;
       int skip = length - rotations;

       ListNode newhead = head;
       for (int i = 0; i < skip - 1; i++) {
            newhead = newhead.next;

        
       }
       head = newhead.next;
       newhead.next = null;

       return head;
    }
}
