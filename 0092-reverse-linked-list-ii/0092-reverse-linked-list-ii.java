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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null || left==right){
            return head;
        }
        
        ListNode dummy = new ListNode(0,head);
        ListNode prevLeft = dummy;
        ListNode curr = head;
        ListNode prev = null;
        
        for(int i=1;i<left;++i){
            prevLeft = curr;
            curr = curr.next;
        }
        
        for(int i=left;i<=right;++i){
            ListNode tempNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNode;
        }
        
        prevLeft.next.next = curr;
        prevLeft.next = prev;
        
        return dummy.next;
        
    }
}