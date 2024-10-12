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
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long,Integer> map = new HashMap<>();
        map.put(0L, 1);
        dfs(root, map, 0, targetSum);
        return ans;
    }
    private void dfs(TreeNode node, Map<Long,Integer> map, long curSum, int targetSum){
        if(node == null){
            return;
        }
        curSum += node.val;
        ans += map.getOrDefault(curSum - targetSum, 0);

        map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        dfs(node.left, map, curSum, targetSum);
        dfs(node.right, map, curSum, targetSum);

        map.put(curSum, map.getOrDefault(curSum, 0) - 1);
    }
}