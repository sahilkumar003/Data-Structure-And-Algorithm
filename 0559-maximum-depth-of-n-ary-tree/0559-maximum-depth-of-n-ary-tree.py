"""
# Definition for a Node.
class Node:
    def __init__(self, val: Optional[int] = None, children: Optional[List['Node']] = None):
        self.val = val
        self.children = children
"""

class Solution:
    def height(self, node):
        if (node == None):
            return 0;
        
        maxHeight = 0;
        for currentNode in node.children:
            maxHeight = max(maxHeight, self.height(currentNode));
            
        return 1 + maxHeight;    
    
    def maxDepth(self, root: 'Node') -> int:
        return self.height(root);
        