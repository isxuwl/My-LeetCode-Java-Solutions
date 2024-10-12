class Solution {
    public void sortColors(int[] nums) {
        // 刷漆
        //     [2 0 2 1 1 1 0] 
        // ->  [2 2 2 2 2 2 2] 先全填上2
        // ->  [1 1 1 1 1 2 2] 统计下0和1的个数之和(作为数字1的右侧边界)，然后填上1
        // ->  [0 0 1 1 1 2 2] 统计下0的个数（作为数字0的右侧边界），然后填上0
        int zero = 0, one = 0, two = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int temp = nums[i];
            nums[two] = 2;
            two ++;
            if(temp <= 1){
                nums[one] = 1;
                one ++;
            }
            if(temp == 0){
                nums[zero] = 0;
                zero ++;
            }
        }
    }
}