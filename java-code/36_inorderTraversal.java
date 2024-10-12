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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.isEmpty()){
            if(root != null){ //root!=null时遍历左子树
                stack.add(root);
                root = root.left;
            }
            else{//!stack.isEmpty()时遍历右子树
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}