class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return ans;
    }
    private void dfs(int i){
        if(i == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        dfs(i + 1);

        path.add(nums[i]);
        dfs(i + 1);
        path.removeLast();
    }
}