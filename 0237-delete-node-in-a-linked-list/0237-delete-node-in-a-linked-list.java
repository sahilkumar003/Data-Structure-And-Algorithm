/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //as we dont have access to the previous node 
        //we will change the value of node to br deleted to the next node value
        //but now two node with same value is here so we remove the next node
        
        node.val = node.next.val;
        node.next = node.next.next;
    }
}