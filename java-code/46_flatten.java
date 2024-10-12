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
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();//存的是节点
        preOrder(root,list);
        int size = list.size();
        for(int i = 1; i < size; i++){
            TreeNode pre = list.get(i - 1), cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }
    private void preOrder(TreeNode root, List<TreeNode> list){
        if(root == null) return;
        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}