class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void bfs(char[][] grid, int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { i, j });
        while(!q.isEmpty()){
            int[] cur = q.poll();
            i = cur[0]; j = cur[1];
            if(0 <= i && i < grid.length && 0 <= j && j < grid[0].length && grid[i][j] == '1') {
                grid[i][j] = '0';
                q.add(new int[] { i + 1, j });
                q.add(new int[] { i - 1, j });
                q.add(new int[] { i, j + 1 });
                q.add(new int[] { i, j - 1 });
            }
        }
    }
}