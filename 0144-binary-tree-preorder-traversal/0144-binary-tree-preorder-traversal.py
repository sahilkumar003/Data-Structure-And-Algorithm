# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preorder(self, node, ans):
        if(node == None):
            return ans;
        
        ans.append(node.val);
        self.preorder(node.left, ans);
        self.preorder(node.right, ans);
        
        return ans;
        
    
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        return self.preorder(root, []);
        