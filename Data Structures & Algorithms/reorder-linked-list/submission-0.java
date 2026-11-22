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

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null ){
            return ;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next!= null ){
            fast=fast.next.next;
            slow = slow.next;
        }

        ListNode current = slow.next;
        slow.next = null;

        ListNode previous = null;

        while(current!=null){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }


        ListNode first = head;
        ListNode second = previous;

        while(second!=null){
            ListNode nextFirst = first.next;
            ListNode nextSecond = second.next;

            first.next = second;
            second.next = nextFirst;

            first = nextFirst;
            second = nextSecond;
        }


    }
}
