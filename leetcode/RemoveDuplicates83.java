// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
// 83. Remove Duplicates from Sorted List
package java5.leetcode;

public class RemoveDuplicates83 {
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

    public ListNode deleteDuplicates(ListNode head) {
        // removing duplicates from singly linked list
        ListNode temp = head;
        while(temp != null){
            if(temp.next != null && temp.val== temp.next.val){
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
            
        }
        return head;
    }
    
}

