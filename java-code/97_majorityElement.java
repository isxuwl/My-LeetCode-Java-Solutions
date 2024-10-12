class Solution {
    int inf = 0x3f3f3f3f;
    public int majorityElement(int[] nums) {
        // 摩尔投票
        // 假设第一个数字为候选数字，计数器为1
        // 遍历后面的数组，如果遇到相同的数组，则计数器加1；如果遇到不同的数字，则计数器减1
        // 如果计数器为 0，则用当前遍历的数字重新初始化为候选数字，计数器为1
        int res = inf, cnt = 0;
        for(int x: nums){
            if(cnt == 0){
                res = x;
                cnt = 1;
            }
            else if(res == x) cnt ++;
            else cnt --;
        }
        return res;
    }
}