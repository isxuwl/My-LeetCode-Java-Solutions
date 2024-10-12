/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ////只要当前根节点是p和q中的任意一个，就返回
        if(root == null || root == p || root == q) return root;
        //根节点不是p和q中的任意一个，那么就继续分别往左子树和右子树找p和q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right= lowestCommonAncestor(root.right, p ,q);
        //左子树没有p也没有q，就返回右子树的结果
        if(left == null) return right;
        //右子树没有p也没有q就返回左子树的结果
        if(right == null) return left;
        return root;
    }
}