class Solution {
    public int findMin(int[] nums) {
        int n = nums.length - 1;
        int l = 0, r = n;
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] > nums[n]){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return nums[l];
    }
}