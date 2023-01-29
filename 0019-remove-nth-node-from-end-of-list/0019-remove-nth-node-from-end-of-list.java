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
    public ListNode removeNthFromEnd(ListNode head, int n) {
//         ListNode temp = head;
//         int size = 0;
//         while(temp!=null){
//             size++;
//             temp = temp.next;
//         }
        
        
//         if(size==1){
//             return null;
//         }
        
//         size -= n;
        
//         if(size == 0){
//             head = head.next;
//             return head;
//         }
        
//         temp = head;
        
//         for(int i=1;i<size;++i){
//             temp = temp.next;
//         }
        
//         temp.next = temp.next.next;
        
//         return head;
        
        if(head==null || head.next==null){
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        for(int i=1;i<=n+1;++i){
            fast = fast.next;
            if(fast==null && i!=n+1){
                head = head.next;
                return head;
            }
        }
        
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        
        return head;
    }
}