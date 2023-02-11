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
    public ListNode reverseLinkedList(ListNode head){
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
    
    public ListNode addTwoNumbers(ListNode first, ListNode second) {
        ListNode newFirst = reverseLinkedList(first);
        ListNode newSecond = reverseLinkedList(second);
        
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        
        ListNode currNF = newFirst;
        ListNode currNS = newSecond;
        int carry = 0;
        
        while(currNF!=null && currNS!=null){
            int sum = 0;
            if(temp.val == -1){
                sum = currNF.val + currNS.val;
            }else{
                sum = currNF.val + currNS.val + carry;
            }
            
            carry = sum/10;
            ListNode n = new ListNode(sum%10);
            temp.next = n;
            temp = n;
            currNF = currNF.next;
            currNS = currNS.next;
        }
        
        while(currNF!=null){
            int sum = 0;
            
            sum = currNF.val + carry;
            
            carry = sum/10;
            ListNode n = new ListNode(sum%10);
            temp.next = n;
            temp = n;
            currNF = currNF.next;
        }
        
        while(currNS!=null){
            int sum = 0;
            
            sum = currNS.val + carry;
            
            carry = sum/10;
            ListNode n = new ListNode(sum%10);
            temp.next = n;
            temp = n;
            currNS = currNS.next;
        }
        
        if(carry!=0){
            ListNode n = new ListNode(carry);
            temp.next = n;
        }
        
        
        
        return reverseLinkedList(dummy.next);
    }
}