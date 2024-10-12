class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];//默认全为0
        //装载我们所有的「待更新」的位置（下标）
        //容器满足单调递减特性 单调栈 下一个更大
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);
        }
        return ans;
    }
}