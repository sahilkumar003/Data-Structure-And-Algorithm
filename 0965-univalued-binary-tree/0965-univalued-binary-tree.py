# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isUnival(self, root, val):
        if(root == None):
            return True;
        
        if(root.val != val):
            return False;
        
        left = self.isUnival(root.left, val);
        right = self.isUnival(root.right, val);
        
        return left and right;
        
        
    
    def isUnivalTree(self, root: Optional[TreeNode]) -> bool:
        return self.isUnival(root, root.val);