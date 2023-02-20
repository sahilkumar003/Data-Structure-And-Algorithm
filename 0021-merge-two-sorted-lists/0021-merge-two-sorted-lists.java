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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-101);
        ListNode ans = dummy;
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        
        while(curr1!=null && curr2!=null){
            if(curr1.val<curr2.val){
                ListNode temp = new ListNode(curr1.val);
                ans.next = temp;
                ans = ans.next;
                curr1 = curr1.next;
            }else{
                ListNode temp = new ListNode(curr2.val);
                ans.next = temp;
                ans = ans.next;
                curr2 = curr2.next;
            }
        }
        
        while(curr1!=null){
          ListNode temp = new ListNode(curr1.val);
            ans.next = temp;
            ans = ans.next;
            curr1 = curr1.next;
        }
        
        while(curr2!=null){
          ListNode temp = new ListNode(curr2.val);
            ans.next = temp;
            ans = ans.next;
            curr2 = curr2.next;
        }
        
        return dummy.next;
    }
}