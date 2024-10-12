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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return check(root.left, root.right);
    }
    private boolean check(TreeNode u, TreeNode v){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(u);
        q.offer(v);
        while(!q.isEmpty()){
            u = q.poll();
            v = q.poll();
            if(u == null && v == null){
                continue;
            }
            if((u == null || v == null) || (u.val != v.val)){
                return false;
            }
            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}