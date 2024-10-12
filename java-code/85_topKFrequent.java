class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x: nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(entries);
        for(int i = 0; i < k; i++){
            Map.Entry<Integer, Integer> x = pq.poll();
            res[i] = x.getKey();
        }
        return res;
    }
}