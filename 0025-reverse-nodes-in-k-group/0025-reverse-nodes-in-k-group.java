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
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(-1,head);
        ListNode ans = dummy;
        ListNode prev = dummy;
        ListNode curr = head;
        
        while(curr!=null){
            int range = k;
            while(curr!=null && range>0){
                prev = curr;
                curr = curr.next;
                range--;
            }
            
            if(range==0){
                prev.next = null;
                ListNode newHead = reverse(head);
                dummy.next = newHead;
                while(newHead.next!=null){
                    newHead = newHead.next;
                }
                dummy = newHead;
                newHead.next = curr;
                head = curr;
            }else{
                break;
            }
        }
        
        return ans.next;
    }
}