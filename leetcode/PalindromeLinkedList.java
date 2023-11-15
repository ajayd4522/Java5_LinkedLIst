// https://leetcode.com/problems/palindrome-linked-list/description/
// 234. Palindrome Linked List
// linkedin, google, facebook, microsoft, amazon, apple

package java5.leetcode;

public class PalindromeLinkedList {
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

    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headSecond =  reverseList(mid);
        ListNode rereverseHead = headSecond;

        // compare the two halves
        while(head != null && headSecond != null){
            if(head.val != headSecond.val){
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }

        reverseList(rereverseHead);

        // if(head == null || headSecond == null){
        //     return true;
        // }
        // return false;

        // same thing
        return (head==null || headSecond==null);
    }
}
