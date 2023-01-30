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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        
        int size = 0;
        ListNode temp = head;
        
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        
        k = k%size;
        
        for(int i=1;i<=k;++i){
            ListNode slow = head;
            ListNode fast = head.next;
            while(fast.next!=null){
                slow = slow.next;
                fast = fast.next;
            }
            ListNode node = new ListNode(fast.val);
            slow.next = null;
            node.next = head;
            head = node;
        }
        
        return head;
    }
}