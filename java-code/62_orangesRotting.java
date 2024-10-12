class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    count ++;
                }else if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }

        int round = 0;
        while(count > 0 && !q.isEmpty()){
            round ++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] orange = q.poll();
                int r = orange[0];
                int c = orange[1];
                if(r - 1 >= 0 && grid[r - 1][c] == 1){
                    grid[r - 1][c] = 2;
                    count --;
                    q.offer(new int[] {r- 1, c});
                }
                if(r + 1 < n && grid[r + 1][c] == 1){
                    grid[r + 1][c] = 2;
                    count --;
                    q.offer(new int[]{r + 1, c});
                }
                if(c - 1 >= 0 && grid[r][c - 1] == 1){
                    grid[r][c - 1] = 2;
                    count --;
                    q.offer(new int[]{r, c - 1});
                }
                if(c + 1 < m && grid[r][c + 1] == 1){
                    grid[r][c + 1] = 2;
                    count --;
                    q.offer(new int[]{r, c + 1});
                }
            }
        }
        if(count > 0) return -1;
        else return round;
    }
}