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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int m =0;
        ListNode counter = head;
        while(counter!=null){
            m++;
            counter=counter.next;
        }

        int k=m-n;

        if(k==0){
            return head.next;
        }
        ListNode prev = head;

        for(int i=0;i<k-1;i++){
            prev = prev.next;
        }

        prev.next = prev.next.next;
        return head;
    }
}
