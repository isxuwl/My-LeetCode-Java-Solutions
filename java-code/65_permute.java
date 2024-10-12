class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0){
            return res;
        }
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }
    private void backtrack(int[] nums){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}