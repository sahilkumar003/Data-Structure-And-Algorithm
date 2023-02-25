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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head.next.next==null){
            return new int[]{-1,-1};
        }
        
//         ArrayList<Integer> list = new ArrayList<>();
//         int k = 0;
//         ListNode curr = head.next;
//         ListNode prev = head;
        
//         while(curr!=null && curr.next!=null){
//             ++k;
//             ListNode temp = curr.next;
//             if((curr.val>temp.val && curr.val>prev.val) || (curr.val<temp.val && curr.val<prev.val)){
//                 list.add(k);
//             }
//             prev = curr;
//             curr = temp;
//         }
        
//         if(list.size()<=1){
//             return new int[]{-1,-1};
//         }
        
//         int min = Integer.MAX_VALUE;
//         int max = Integer.MIN_VALUE;
        
//         for(int i=1;i<list.size();++i){
//             min = Math.min(min,list.get(i)-list.get(i-1));
//             max = Math.max(max,list.get(i)-list.get(0));
//         }
        
//         return new int[]{min,max};
        
        ListNode prev = head;
        ListNode curr = head.next;
        int min = Integer.MAX_VALUE;
        int last = -1;
        int first = Integer.MAX_VALUE;
        
        for(int i=0;curr!=null && curr.next!=null;++i){
            ListNode temp = curr.next;
             if((curr.val>temp.val && curr.val>prev.val) || (curr.val<temp.val && curr.val<prev.val)){
                if(last!=-1){
                    min = Math.min(min,i-last);
                }
                 first = Math.min(first,i);
                 last = i;
            }
            prev = curr;
            curr = temp;
        }
        
        if(min==Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }
        return new int[]{min,last-first};
    }
}