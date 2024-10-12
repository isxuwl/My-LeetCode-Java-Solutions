class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //初始化邻接表
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
         //准备入度表
        int[] indeg = new int[numCourses];
        for(int[] p: prerequisites){
            graph.get(p[1]).add(p[0]);//[1]->[0]
            indeg[p[0]] ++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indeg.length; i++){
            if(indeg[i] == 0){
                q.offer(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            count ++;
            ArrayList<Integer> now = graph.get(cur);
            for(int x: now){
                if(--indeg[x] == 0){
                    q.offer(x);
                }
            }
        }
        return count == numCourses;
    }
}