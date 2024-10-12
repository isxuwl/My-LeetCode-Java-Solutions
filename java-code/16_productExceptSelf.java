class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] suf = new int[n];
        suf[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--){
            suf[i] = suf[i + 1] * nums[i + 1];
        }
        int pre = 1;
        for(int i = 0; i < n; i++){
            suf[i] *= pre;
            pre *= nums[i];
        }
        return suf;
    }
}