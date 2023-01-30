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
    public int getSize(ListNode head){
        int size = 0;
        ListNode temp = head;
        while(temp!=null){
            size++;
            temp = temp.next;
        }

        return size;
    }
    
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] arr = new ListNode[k];
        Arrays.fill(arr,null);
        int index = 0;

        int totalSize = getSize(head);
        int partSize = totalSize/k;
        int extraSize = totalSize%k;

        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            arr[index++] = curr;
            int sizeOfEachPart = partSize;
            while(sizeOfEachPart>0 && curr!=null){
                prev = curr;
                curr = curr.next;
                sizeOfEachPart--;
            }

            if(extraSize>0 && curr!=null){
                prev = curr;
                curr = curr.next;
                extraSize--;
            }

            if(prev!=null){
                head = curr;
                prev.next = null;
            }
        }
        return arr;
    }
}