# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorder(self, node, traversalList):
        if(node == None):
            return;
        
        self.postorder(node.left, traversalList);
        self.postorder(node.right, traversalList);
        traversalList.append(node.val);
        
        return;
    
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        traversalList = [];
        self.postorder(root, traversalList);
        return traversalList;
        