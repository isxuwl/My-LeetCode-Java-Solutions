class Solution {
    public int quickselect(int[] q, int l, int r, int k) {
        if (l >= r) return q[l];
        int i = l - 1, j = r + 1, x = q[l + r >> 1];
        while(i < j){
            do i++; while(q[i] > x);
            do j--; while (q[j] < x);
            if (i < j) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        if (j - l + 1 >= k) return quickselect(q, l, j, k);
        else return quickselect(q, j + 1, r, k - (j - l + 1));
    }
    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, 0, nums.length - 1, k);
    }
}