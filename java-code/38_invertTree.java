class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;

            if(cur.left != null){
                q.offer(cur.left);
            }
            if(cur.right != null){
                q.offer(cur.right);
            }
        }
        return root;
    }
}
