class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n == 0) return;
        //从后向前便利
        for(int i = n - 1; i >= 0; i--){
             //如果i为0，说明数组从后到前是递增（654321）的,没有更大的了
             //直接重排序变成一个递减的（123456）符合题意
             if(i == 0){
                Arrays.sort(nums);
                return;
             }else if(nums[i] > nums[i - 1]){
                //一旦出现后一个数字nums[i]比前一个大，说明存在更大的整数
                //对nums[i]及后面的数组排序，从小到大
                Arrays.sort(nums, i, n);
                for(int j = i; i < n; j ++){
                    //由于从i开始后面已经排序
                    //那么保证获得比nums[i-1]大的数，是[i,...,len-1]中最小的,交换即可
                    if(nums[j] > nums[i - 1]){
                        swap(nums, j, i - 1);
                        return;
                    }
                }
             }
            
        }
    }
    private void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
    }
}