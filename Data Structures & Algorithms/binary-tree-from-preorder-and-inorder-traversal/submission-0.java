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
    int[] preorder;
    HashMap<Integer,Integer> map;
    int preIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return construct(0,inorder.length-1);
    }
    public TreeNode construct(int leftRange,int rightRange){
        if(leftRange > rightRange) return null;

        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);

        int rootIdx = map.get(rootVal);

        root.left = construct(leftRange,rootIdx-1);
        root.right = construct(rootIdx+1,rightRange);

        return root;
    }
}
