# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorder(self, node, traversalList):
        if(node == None):
            return;
        
        self.inorder(node.left, traversalList);
        traversalList.append(node.val);
        self.inorder(node.right, traversalList);
        
        return;
    
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        traversalList = [];
        self.inorder(root, traversalList);
        return traversalList;