class Solution {
    public boolean canJump(int[] nums) {
        // 在整个过程中只有遇到0才会有可能中断，所以我们找到0的位置，判断是否可以跳过这个0
        int n = nums.length;
        boolean isCan = true;
        if(n == 1){
            return true;
        }
        for(int i = 0; i < n - 1; i++){
            if(nums[i] == 0){
                isCan = false;
                for(int j = i - 1; j >= 0; j--){
                    if(j + nums[j] > i){
                        isCan = true;
                        break;
                    }
                }
                if(isCan == false){
                    return isCan;
                }
            }
        }
        return isCan;
    }
}