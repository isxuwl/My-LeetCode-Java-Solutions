class Solution {
    public int minDistance(String word1, String word2) {
        // dp[i][j] 表示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，最近编辑距离为dp[i][j]
        // 至于dp[i-1][j-1]位置，如果两个位置的字符不相等，那么就需要进行替换操作。
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        // 初始化，全部 删除/添加 自己，用 删除/添加 的操作
        for(int i = 0; i <= n; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j <= m; j++){
            dp[0][j] = j;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                int falg = 0;
                if(word1.charAt(i - 1) != word2.charAt(j - 1)){
                    falg = 1;
                }
                dp[i][j] = Math.min(Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1), dp[i - 1][j - 1] + falg);
            }
        }
        return dp[n][m];
    }
}