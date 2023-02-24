Use zero nodes to store the sum of merged nodes, remove the last zero node, which is unused.
Use prev to connect and move among all zero nodes;
Use head to traverse nodes between zero nodes, and add their values to the previous zero node;
Always use prev point to the node right before current zero node, hence we can remove the last zero node easily.
​
​
public ListNode mergeNodes(ListNode head) {
ListNode dummy = new ListNode(Integer.MIN_VALUE), prev = dummy;
while (head != null && head.next != null) {
prev.next = head; // prev connects next 0 node.
head = head.next; // head forward to a non-zero node.
while (head != null && head.val != 0) { // traverse all non-zero nodes between two zero nodes.
prev.next.val += head.val; // add current value to the previous zero node.
head = head.next; // forward one step.
}
prev = prev.next; // prev point to the summation node (initially 0).
}
prev.next = null; // cut off last 0 node.
return dummy.next;
}