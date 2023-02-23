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
    
    public int[] nextLargerNodes(ListNode head) {
        head = reverse(head);
        ListNode tail = head;
        ListNode curr = head;
        int size = 1;
        
        while(tail.next!=null){
            tail = tail.next;
            size++;
        }

        int []ans = new int[size];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=size-1;i>=0;--i){
            while(stack.size()!=0 && stack.peek()<=curr.val){
                stack.pop();
            }
            
            if(stack.size()==0){
                ans[i] = 0;
            }else{
                ans[i] = stack.peek();
            }
            
            stack.push(curr.val);
            curr = curr.next;
        }
        
        head = reverse(head);
        return ans;
    }
}