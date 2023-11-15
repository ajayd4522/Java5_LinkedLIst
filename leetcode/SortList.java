// https://leetcode.com/problems/sort-list/description/
// 148. Sort List

package java5.leetcode;

import java.util.List;

public class SortList {
    public class ListNode {
         int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

    // first we are doing it by merge sort
    public class MergeSort {
        

        public ListNode sortList(ListNode head) {
            // base condition
            if(head == null || head.next == null){
                return head;
            }

            ListNode mid = middleNode(head);
            ListNode first = sortList(head);
            ListNode second = sortList(mid);

            return mergeTwoLists(first, second);
        }

        // !!!! It is  very imporatand and complex so carefull with this
        public ListNode middleNode(ListNode head) {
            ListNode midPrev = null;
            ListNode temp = head;

            while(temp != null && temp.next != null){
                midPrev = (midPrev == null)? head : midPrev.next;
                temp = temp.next.next;

            }

            ListNode mid = midPrev.next;
            midPrev.next = null;
            return mid;

        }

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dumyHead = new ListNode();
            ListNode tail = dumyHead;
    
            while(list1 != null && list2!= null){
                if(list1.val < list2.val){
                    tail.next = list1;
                    list1 = list1.next;
                    tail = tail.next;
                } else {
                    tail.next = list2;
                    list2 = list2.next;
                    tail = tail.next;
                }
            }
    
            tail.next = (list1 != null)? list1:list2;
            return dumyHead.next;
        }
    }

    // second we are doing it by bubble sort
    public class BubbleSort {

        public ListNode sortList(ListNode head) {
            // find the size of linked list
            int size = linkedListLength(head);
            bubbleSort (size - 1, 0);
            return head;
        }

        private void bubbleSort(int row, int col) {
            if(row == 0){
                return;
            }
    
            if(col < row){
                ListNode first = getNode(col);
                ListNode second = getNode(col + 1);

                // three basic condition
                // first swaping at the start
                if(first.val > second.val){
                    if(first == head){
                        head = second;
                        first.next = second.next;
                        second.next = first;
                    } else if(second.next == null){
                        ListNode prev = getNode(col - 1);
                        prev.next = second;
                        second.next = first;
                        first.next = null;
                    } else {
                        ListNode prev = getNode(col -1);
                        prev.next = second;
                        first.next = second.next;
                        second.next = first;
                    }

                    bubbleSort(row, col+1);
                } else {
                    bubbleSort(row--, 0);
                }
            }
        }

        public ListNode getNode (int index){    // finding the node from the given value
            ListNode temp = head;
            int count = 0;
            while(temp == null){
                if(count == index){
                    return temp;
                }
                temp = temp.next;
    
            }
    
            return null;
        }

        public int  linkedListLength (ListNode head){
            int size = 0;
            ListNode temp = head;

            while(temp != null){
                size++;
                temp = temp.next;
            }

            return size;
        }


    }
}
