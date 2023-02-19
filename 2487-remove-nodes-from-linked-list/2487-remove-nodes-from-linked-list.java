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
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
    
    public ListNode removeNodes(ListNode head) {
        ListNode newHead = reverse(head);
        
        ListNode curr = newHead;
        ListNode prev = null;
        int max = 0;
        
        while(curr!=null){
            if(curr.val>=max){
                max = curr.val;
                prev = curr;
                curr = curr.next;
            }else{
                prev.next = curr.next;
                curr = curr.next;
            }
        }
        
        ListNode ans = reverse(newHead);
        return ans;
    }
}