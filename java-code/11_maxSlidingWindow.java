class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 子串
        int n = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.value - a.value);
        for(int i = 0; i < k; i++){
            pq.offer(new Pair(nums[i],i));
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek().value;
        for(int i = k; i < n; i++){
            pq.offer(new Pair(nums[i],i));
            while(pq.peek().index <= i - k){
                pq.poll();
            }
            ans[i - k + 1] = pq.peek().value;
        }
        return ans;
    }
    private static class Pair {
        int value;
        int index;
        
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}