# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def heightOfTree(self, node):
        if(node == None):
            return 0;
        
        leftchild = 1 + self.heightOfTree(node.left);
        rightchild = 1 + self.heightOfTree(node.right);
        
        return max(leftchild, rightchild);
    
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        return self.heightOfTree(root);
        
        