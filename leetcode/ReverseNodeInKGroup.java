// https://leetcode.com/problems/reverse-nodes-in-k-group/description/
// 25. Reverse Nodes in k-Group
// google, amazon, facebook, microsoft

package java5.leetcode;

public class ReverseNodeInKGroup {
    // this question is same as previous one - reversing the list in range
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

        int length = getLength(head);
        int count = length/k;

        while(count > 0){
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
            previous = newEnd;
            count--;

        }

        
        return head;
    }
    public int getLength(ListNode head) {
		ListNode node = head;
		int length = 0;
		while (node != null) {
			length++;
			node = node.next;
		}
		return length;
	}
}

