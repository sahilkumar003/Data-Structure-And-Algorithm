/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        
       HashMap<ListNode,Integer> map = new HashMap<>();
        
        while(curr1!=null){
            map.put(curr1,1);
            curr1 = curr1.next;
        }
        
        while(curr2!=null){
            if(map.containsKey(curr2)){
                return curr2;
            }
            curr2 = curr2.next;
        }
        
        return null;
    }
}