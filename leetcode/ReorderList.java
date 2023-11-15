// https://leetcode.com/problems/reorder-list/description/
// 143. Reorder List
// Google.Facebook


package java5.leetcode;

public class ReorderList {
    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
    public ListNode middleNode(ListNode head) {
            ListNode s = head;
            ListNode f = head;
    
            while (f != null && f.next != null) {
                s = s.next;
                f = f.next.next;
            }
            return s;
        }
    public ListNode reverseList(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode prev = null;
            ListNode present = head;
            
    
            while (present != null) {
                ListNode next = present.next;
                present.next = prev;
                prev = present;
                present = next;
                // if (next != null) {
                //     next = next.next;
                // }
            }
            return prev;
        }

    public void reorderList(ListNode head) {
        //base condition
        if(head == null && head.next == null){
            return;
        }

        // first find the mid and reverse it
        ListNode mid = middleNode(head);

        ListNode headSecond = reverseList(mid);
        ListNode headFirst = head;

        // rearrange the linked list
        while(headFirst != null && headSecond != null){
            // take temp node for moving to next node
            ListNode temp = headFirst.next;
            headFirst.next = headSecond;
            headFirst = temp;

            temp = headSecond.next;
            headSecond.next = headFirst;
            headSecond = temp;

        }

        // if the size is odd then headFirst will not be able to reach at null
        // attach next remaining nodes of headFirst
        if(headFirst != null){
            headFirst.next = null;
        }
    }
}
