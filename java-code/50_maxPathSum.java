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
    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode node){
        if(node == null){
            return 0;// 没有节点，和为 0
        }
        int leftVal = dfs(node.left);// 左子树最大链和
        int rightVal = dfs(node.right);// 右子树最大链和

        ans = Math.max(ans, leftVal + rightVal + node.val); // 两条链拼成路径
        return Math.max(Math.max(leftVal, rightVal) + node.val, 0);// 当前子树最大链和
    }
}