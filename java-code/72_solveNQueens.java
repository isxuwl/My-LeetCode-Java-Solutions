class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                chess[i][j] = '.';
            }
        }
        dfs(res, chess, 0);
        return res;
    }
    private void dfs(List<List<String>> res, char[][] chess, int row){
         //row表示第几行
         if(row == chess.length){
            res.add(arrayToList(chess));
            return;
         }
        for(int col = 0; col < chess.length; col ++){
            if(isValid(chess, row, col)){
                chess[row][col] = 'Q';
                dfs(res, chess, row + 1);
                chess[row][col] = '.';
            }
        }
    }
     //row表示第几行，col表示第几列
    private boolean isValid(char[][] chess, int row, int col){
        ////判断当前列有没有皇后,因为他是一行一行往下走的，我们只需要检查走过的行数即可
        for(int i = 0; i < row; i++){
            if(chess[i][col] == 'Q'){
                return false;
            }
        }
         //判断当前坐标的右上角有没有皇后
        for(int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        //判断当前坐标的左上角有没有皇后
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
                if(chess[i][j] == 'Q'){
                    return false;
                }
        }
         return true;
    }
    private List<String> arrayToList(char[][] chess){
        List<String> path = new ArrayList<>();
        for(int i = 0; i < chess.length; i++){
            path.add(new String(chess[i]));
        }
        return path;
    }
}