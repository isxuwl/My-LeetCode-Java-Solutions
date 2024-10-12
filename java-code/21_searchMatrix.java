class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        for(int i = 0; i < n; i++){
            int l = 0, r = m - 1;
            while(l < r){
                int mid = l + r + 1 >> 1;
                if(matrix[i][mid] <= target) l = mid;
                else r = mid - 1;
            }
            if(matrix[i][r] == target) return true;
        }
        return false;
    }
}