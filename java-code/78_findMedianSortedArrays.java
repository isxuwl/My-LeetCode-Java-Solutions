class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if(total % 2 == 0){
            int l = find(nums1, 0, nums2, 0, total / 2);
            int r = find(nums1, 0, nums2, 0, total / 2 + 1);
            return (l + r) / 2.0;
        }
        return find(nums1, 0, nums2, 0, total / 2 + 1) / 1.0;
    }
    private int find(int[] nums1, int i, int[] nums2, int j, int k){
        if(nums1.length - i > nums2.length - j){
            return find(nums2, j, nums1, i, k);
        }
        if(nums1.length == i){
            return nums2[j + k - 1];
        }
        if(k == 1){
            return Math.min(nums1[i], nums2[j]);
        }
        int si = Math.min(nums1.length, i + k / 2);
        int sj = j + k - k / 2;
        if(nums1[si - 1] > nums2[sj - 1]){
            return find(nums1, i, nums2, sj, k - (sj - j));
        }else{
            return find(nums1, si, nums2, j, k - (si - i));
        }
    }
}