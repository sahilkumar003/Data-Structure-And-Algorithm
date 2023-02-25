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
    
    public int pairSum(ListNode head) {
        ListNode dummy = new ListNode(-1,head);
        int sum = 0;
        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = reverse(slow);
        prev = prev.next;
        fast = dummy.next;
        
        while(prev!=null){
            int temp = fast.val + prev.val;
            sum = Math.max(sum,temp);
            prev = prev.next;
            fast = fast.next;
        }
        
        return sum;
    }
}