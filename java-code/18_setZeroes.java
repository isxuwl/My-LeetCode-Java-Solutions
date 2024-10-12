class Solution {
    public void setZeroes(int[][] matrix) {
        //用matrix第一行和第一列记录该行该列是否有0,作为标志位
        // 但是对于第一行,和第一列要设置一个标志位
        //为了防止自己这一行(一列)也有0的情况.
        int row = matrix.length;
        int col = matrix[0].length;
        boolean row0_flag = false;
        boolean col0_flag = false;
        //第一行是否有0
        for(int j = 0; j < col; j++){
            if(matrix[0][j] == 0){
                row0_flag = true;
                break;
            }
        }
        //第一列是否有0
        for(int i = 0; i < row; i++){
            if(matrix[i][0] == 0){
                col0_flag = true;
                break;
            }
        }
        //把第一行第一列作为标志位 
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;//第一行/列
                }
            }
        }
        //置0
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(row0_flag){
            for(int j = 0; j < col; j++){
                matrix[0][j] = 0;
            }
        }
        if(col0_flag){
            for(int i = 0; i < row; i++){
                matrix[i][0] = 0;
            }
        }
    }
}