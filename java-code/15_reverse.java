class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);//反转全部
        reverse(nums, 0, k - 1);//反转前k个
        reverse(nums, k, n - 1);//反转后n-k个
    }
    private void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i ++;
            j --;
        }
    }
}