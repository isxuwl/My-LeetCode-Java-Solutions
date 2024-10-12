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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer,Integer> index = new HashMap<>();
        for(int i = 0; i < n; i++){
            index.put(inorder[i], i);
        }
        return dfs(preorder, 0, n, inorder, 0, n, index);// 左闭右开区间
    }
    private TreeNode dfs(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, Map<Integer,Integer> index){
        if(preL == preR){//空
            return null;
        }
        int leftSize = index.get(preorder[preL]) - inL;// 左子树的大小 
        TreeNode left = dfs(preorder, preL + 1, preL + 1 + leftSize, inorder, inL, inL + leftSize, index);
        TreeNode right = dfs(preorder, preL + 1 + leftSize, preR, inorder, inL + 1 + leftSize, inR, index);
        return new TreeNode(preorder[preL], left, right);
    }
}