/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> traversal(TreeNode root,List<Integer> list){
        if(root==null){
            return list;
        }
        
        traversal(root.left,list);
        list.add(root.val);
        traversal(root.right,list);
        
        return list;
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        return traversal(root,new ArrayList<Integer>());
    }
}