class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 左端点 int mid = l + r >> 1; >=
        // 右端点 int mid = l + r + 1 >> 1; <= x
        int n = matrix.length, m = matrix[0].length;
        int l = 0, r = n - 1;
        while(l < r){
            int mid = l + r + 1 >> 1;
            if(matrix[mid][0] <= target){
                l = mid;
            }
            else{
                r = mid - 1;
            }
        }

        int row = r;
        if(matrix[row][0] == target) return true;
        if(matrix[row][0] > target) return false;

        l = 0;
        r = m - 1;
        while(l < r){
            int mid = l + r + 1 >> 1;
            if(matrix[row][mid] <= target){
                l = mid;
            }
            else{
                r = mid - 1;
            }
        }
        int col = r;
        return matrix[row][col] == target;
    }
}