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
    
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(-1,head);
        ListNode slow = head;
        ListNode fast = head;
        
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow.next = reverse(slow.next);
        slow = slow.next;
        dummy = dummy.next;
        
        while(slow!=null){
            if(dummy.val!=slow.val){
                return false;
            }
            slow = slow.next;
            dummy = dummy.next;
        }
        return true;
    }
}