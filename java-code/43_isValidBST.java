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
    //中序遍历 左根右
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        
        if(root.val <= pre){
            return false;
        }
        else{
            pre = root.val;
        }
        
        if(!isValidBST(root.right)){
            return false;
        }

        return true;
    }
}