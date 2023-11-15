package java5.leetcode;

import java.util.List;

public class LinkedLIstCycle2 {

    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) {
                 val = x;
                 next = null;
             }
         }
    
    public int cycleLength(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
    
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
    
                if(fast == slow){
                    // calculate the length
                    ListNode temp = slow;
                    int length = 0;
    
                    do{
                        temp = temp.next;
                        length++;
                    } while (temp != slow);
                    
                    return length;
                }
            }
    
            return 0;
        }

    public ListNode detectCycle(ListNode head) {
        
            ListNode fast = head;
            ListNode slow = head;

            int length = 0;
    
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
    
                if(fast == slow){
                   length =  cycleLength(slow);
                   break;
                }
            }
    
            if(length == 0){
                return null;
            }

            ListNode f = head;
            ListNode s = head;

            while(length > 0){
                s = s.next;
                length--;

                
            }

            // keep moving both f and s until they reach to same point thats the start of cycle in LL
            while(f != s){
                f = f.next;
                s = s.next;

            }

            return s;
        
    }
}
