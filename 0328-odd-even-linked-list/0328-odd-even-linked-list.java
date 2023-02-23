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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode curr = head;
        ListNode prev = head;
        ListNode tail = head;
        int size = 1;
        int k = 0;
        
        while(tail.next!=null){
            tail = tail.next;
            size++;
        }
        
        while(curr!=null && size-->0){
            ++k;
            if(k%2==0){
                if(curr==head){
                    ListNode temp = new ListNode(head.val);
                    head = head.next;
                    curr = head;
                    prev = head;
                    tail.next = temp;
                    tail = temp;
                    continue;
                }else{
                    ListNode temp = new ListNode(curr.val);
                    tail.next = temp;
                    tail = temp;
                    prev.next = curr.next;
                }
            }else{
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}