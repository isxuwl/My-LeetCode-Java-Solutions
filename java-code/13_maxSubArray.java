class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(sum <= 0){
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}