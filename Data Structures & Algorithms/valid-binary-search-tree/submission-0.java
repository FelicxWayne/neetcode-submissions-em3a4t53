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
    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return dfs(root,min,max);
    }
    public boolean dfs(TreeNode node, long min, long max){
        if(node == null){
            return true;
        }
        else if(node.val<=min || node.val>=max){
            return false;
        }
        return dfs(node.left,min,node.val)&&dfs(node.right,node.val,max);
    }
}
