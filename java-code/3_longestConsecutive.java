class Solution {
    public int longestConsecutive(int[] nums) {
        // set哈希表
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int res = 0;
        for(int num:set){
            if(!set.contains(num - 1)){
                int curNum = num;
                int curRes = 1;
                while(set.contains(curNum + 1)){
                    curNum++;
                    curRes++;
                }
                res = Math.max(res,curRes);
            }
        }
        return res;
    }
}