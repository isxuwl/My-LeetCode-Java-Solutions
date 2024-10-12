class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return -1;
        if(n == 1) return nums[0] == target ? 0 : -1;
        int l = 0, r = n - 1;
         // 第一次「二分」：从中间开始找，找到第一个满足 >=nums[0] 的分割点（旋转点）
        while(l < r){
            int mid = l + r + 1 >> 1;
            if(nums[mid] >= nums[0]){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        // 第二次「二分」：通过和 nums[0] 进行比较，得知 target 是在旋转点的左边还是右边
        if(target >= nums[0]){
            l = 0;
        }else{
            l = l + 1;
            r = n - 1;
        }
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] >= target){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return nums[r] == target ? r : -1;
    }
}