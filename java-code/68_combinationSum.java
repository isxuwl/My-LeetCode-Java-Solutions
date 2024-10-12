class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0){
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        dfs(0, candidates, target, temp);
        return res;
    }
    private void dfs(int start, int[] candidates, int target, List<Integer> temp){
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(temp));
        }
        else{
            for(int i = start; i < candidates.length; i++){
                temp.add(candidates[i]);
                dfs(i, candidates, target - candidates[i], temp);
                temp.removeLast();
            }
        }
    }
}