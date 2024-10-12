class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        int n = nums.length;
        if(n == 0) return ans;
        int l = 0, r= n - 1;
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if(nums[l] != target) return ans;
        ans[0] = l;
        l = 0;
        r = n - 1;
        while(l < r){
            int mid = l + r + 1 >> 1;
            if(nums[mid] <= target){
                l = mid;
            }
            else r = mid - 1;
        }
        ans[1] = r;
        return ans;
    }
}