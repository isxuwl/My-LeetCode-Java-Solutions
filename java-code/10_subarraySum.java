class Solution {
    /**
    转化了一步
    将问题转化为寻找和为k的子数组，
    而不是直接在数组中寻找和为k的连续元素，
    这样就可以使问题在一次遍历中解决
    对于每个前缀和，都检查是否存在一个早先的前缀和，使得它们的差等于k。
    如果存在，就找到了一个和为k的子数组。 
    */
    public int subarraySum(int[] nums, int k) {
        // 子串
        int count = 0, pre = 0;
        Map<Integer,Integer> hashmap = new HashMap<>();
        hashmap.put(0,1); // 初始化时为空区间，则前缀和为0，出现的次数为1
        for(int i = 0; i < nums.length; i ++){
            pre += nums[i];
            if(hashmap.containsKey(pre - k)){
                count += hashmap.get(pre - k);
            }
            hashmap.put(pre,hashmap.getOrDefault(pre,0) + 1);
        }
        return count;
    }
}