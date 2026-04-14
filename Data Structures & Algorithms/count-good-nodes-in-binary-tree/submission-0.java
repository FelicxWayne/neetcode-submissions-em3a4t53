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
    int good = 0; 
    public int goodNodes(TreeNode root) {
        dfs(root,root.val);
        return good;
    }
    public void dfs(TreeNode root,int prev){
        if(root == null) return;

        if(root.val >= prev){
            good++;
        }
        prev = Math.max(prev,root.val);
        dfs(root.left,prev);
        dfs(root.right,prev);
    }
}
