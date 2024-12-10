"""
# Definition for a Node.
class Node:
    def __init__(self, val: Optional[int] = None, children: Optional[List['Node']] = None):
        self.val = val
        self.children = children
"""

class Solution:
    def postorderTraversal(self, node, ans):
        if(node == None):
            return ans;
        
        for currentChild in node.children:
            self.postorderTraversal(currentChild, ans);
            
        ans.append(node.val);
        return ans;
    
    def postorder(self, root: 'Node') -> List[int]:
        return self.postorderTraversal(root, []);