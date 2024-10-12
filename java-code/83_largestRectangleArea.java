class Solution {
    public int largestRectangleArea(int[] heights) {
        // 单调栈 下一个更大
        int n = heights.length;
        int[] l = new int[n], r = new int[n];
        Arrays.fill(l, -1); Arrays.fill(r, n);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                r[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                l[stack.pop()] = i;
            }
            stack.push(i);
        }
        int ans = 0;
        for(int i = 0; i <n; i++){
            int h = heights[i], a = l[i], b = r[i];
            ans = Math.max(ans, (b - a - 1) * h);
        }
        return ans;
    }
}