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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        int depth = 0;
        if(root == null) return res;
        dfs(root,res,depth);
        return res;
    }
    void dfs(TreeNode root,List<Integer> res,int depth){
        if(root == null) return;
        
        if(depth == res.size()){
            res.add(root.val);
        }

        dfs(root.right,res,depth+1);
        dfs(root.left,res,depth+1);
    }
}
