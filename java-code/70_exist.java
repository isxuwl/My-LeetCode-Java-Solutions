class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int i, int j, String word, int cur){
        if(cur == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(cur)){
            return false;
        }
        char c = board[i][j];
        board[i][j] = '.';
        boolean res = dfs(board, i + 1, j, word, cur + 1) || dfs(board, i - 1, j, word, cur + 1)
        || dfs(board, i, j + 1, word, cur + 1) || dfs(board, i, j - 1, word, cur + 1);
        board[i][j] = c;
        return res;
    }
}