class Solution {
    public int firstMissingPositive(int[] nums) {
        //让每个数字n都回到下标为n-1的家里
        int len = nums.length;
        for(int i = 0; i < len; i ++){
            while(nums[i] > 0 && nums[i] < len && nums[nums[i] - 1] != nums[i]){
                //// 满足在指定范围内、并且没有放在正确的位置上，才交换
                swap(nums,nums[i] - 1, i);
            }
        }
        for(int i = 0; i < len; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return len + 1;
    }
    private void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}