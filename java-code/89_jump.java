class Solution {
    public int jump(int[] nums) {
        // f[i] 为到达第 i 个位置所需要的最少步数
        int n = nums.length;
        int[] f = new int[n];
        for(int i = 1, j = 0; i < n; i++){
            while(j + nums[j] < i) j ++;
            f[i] = f[j] + 1;
        }
        return f[n - 1];
    }
}