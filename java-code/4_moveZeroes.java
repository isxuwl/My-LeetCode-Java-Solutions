class Solution {
    public void moveZeroes(int[] nums) {
        // 双指针
        int idx = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(nums[i] != 0){//不为0
                int temp = nums[idx];//临时变量存储
                nums[idx] = nums[i];
                nums[i] = temp;
                idx ++;
            }
        }
    }
}