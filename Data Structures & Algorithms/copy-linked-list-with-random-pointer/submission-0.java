/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> copies = new HashMap<>();

        for(Node curr = head;curr!=null;curr = curr.next){
            copies.put(curr,new Node(curr.val));
        }

        for(Node curr = head; curr!= null ; curr = curr.next){
            Node copied = copies.get(curr);
            copied.next = copies.get(curr.next);
            copied.random = copies.get(curr.random);
        }

        return copies.get(head);
    }
}
