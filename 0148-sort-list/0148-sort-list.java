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
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                ListNode temp = new ListNode(head1.val);
                curr.next = temp;
                curr = temp;
                head1 = head1.next;
            }else{
                ListNode temp = new ListNode(head2.val);
                curr.next = temp;
                curr = temp;
                head2 = head2.next;
            }
        }
        
        while(head1!=null){
             ListNode temp = new ListNode(head1.val);
                curr.next = temp;
                curr = temp;
                head1 = head1.next;
        }
        
        while(head2!=null){
            ListNode temp = new ListNode(head2.val);
                curr.next = temp;
                curr = temp;
                head2 = head2.next;
        }
        return dummy.next;
    }
    
    public ListNode getMid(ListNode head){
        ListNode prevMid = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            prevMid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prevMid.next = null;
        return slow;
    }
    
    
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
        return merge(left,right);
    }
}