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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headS = reverseList(mid);
        
        while(head!=null && headS!=null){
            if(head.val != headS.val){
                break;
            }
            head = head.next;
            headS = headS.next;
        }
        
        if(head == null || headS == null){
            return true;
        }
        return false;
    }
    public ListNode middleNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head){
         if(head==null || head.next==null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode temp = curr.next;
        while(curr!=null){
            curr.next = prev;
            prev = curr;
            curr = temp;
            if(temp !=null){
            temp = temp.next;
            }
        }
        return prev;
    }
}
