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
    public ListNode mergeNodes(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        int sum = 0;
        
        while(curr!=null){
            sum += curr.val;
            if(curr.val==0){
                ListNode temp = new ListNode(sum);
                sum = 0;
                prev.next = temp;
                temp.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }
        
        while(head.val==0){
            head = head.next;
        }
        
        curr = head;
        prev = head;
        
        while(curr!=null){
            if(curr.val==0){
                prev.next = curr.next;
            }else{
                prev = curr;
            }
            curr = curr.next;
        }
        
        return head;
    }
}