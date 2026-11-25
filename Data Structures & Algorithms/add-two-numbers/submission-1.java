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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        ListNode ini = new ListNode(0,null);
        ListNode start = ini;

        int carry = 0;
        while(pointer1!=null && pointer2!=null){
            int sum = pointer1.val + pointer2.val+carry;
            int digi = sum%10;
            start.next = new ListNode(digi,null);
            carry = sum/10;
            pointer1=pointer1.next;
            pointer2=pointer2.next;
            start=start.next;
        }

        while(pointer2!=null){
            int sum = pointer2.val + carry;
                start.next = new ListNode(sum%10,null);
                carry = sum / 10;
                pointer2 = pointer2.next;
                start=start.next;
         }
        while(pointer1!=null){
            int sum = pointer1.val + carry;
            start.next = new ListNode(sum%10,null);
            carry = sum / 10;
            pointer1 = pointer1.next;
            start=start.next;
        }
        if (carry > 0) {
            start.next = new ListNode(carry);
        }
        return ini.next;
        
    }
}
