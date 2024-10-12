class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int x = 0, y = 0, d = 0, i = 0; i < n * m; i ++){
            ans.add(matrix[x][y]);
            matrix[x][y] = Integer.MAX_VALUE;
            int nx = x + dirs[d][0], ny = y + dirs[d][1];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m || matrix[nx][ny] == Integer.MAX_VALUE){
                d = (d + 1) % 4;
                nx = x + dirs[d][0]; ny = y + dirs[d][1];
            }
            x = nx; y = ny;
        }
        return ans;
    }
}