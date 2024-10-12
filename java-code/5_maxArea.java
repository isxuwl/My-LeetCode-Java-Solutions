class Solution {
    public int maxArea(int[] height) {
        // 双指针
        int l = 0, r = height.length - 1;
        int ans = 0;
        while(l < r){
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans,area);
            if(height[l] <= height[r]){
                l ++;
            }
            else{
                r --;
            }
        }
        return ans;
    }
}