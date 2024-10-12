class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int[] cur = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(cur[1] < intervals[i][0]){
                ans.add(cur);
                cur = intervals[i];
            }else{
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }
        }
        ans.add(cur);
        // Convert the List<int[]> to int[][]
        return ans.toArray(new int[ans.size()][]);
    }
}