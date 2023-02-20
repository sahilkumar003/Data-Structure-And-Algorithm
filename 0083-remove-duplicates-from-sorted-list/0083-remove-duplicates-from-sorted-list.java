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
    public ListNode deleteDuplicates(ListNode head) {
        
//         ListNode dummy = new ListNode(-101,head);
//         ListNode prev = dummy;
//         ListNode curr = head;
        
//         while(curr!=null){
//             if(curr.val == prev.val){
//                 prev.next = curr.next;
//             }else{
//             prev = curr;
//             }
//            curr = curr.next;
//         }
        
//         return dummy.next;
        
        
        ListNode dummy = new ListNode(-101,head);
        ListNode curr = dummy;
        
        while(curr.next!=null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}