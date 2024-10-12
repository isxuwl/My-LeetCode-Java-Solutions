class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        // dp[i][j]表示text1[0,i]范围和text2[0,j]范围构成的最长公共子序列
        int[][] dp = new int[n][m];
        dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        for(int i = 1; i < n; i++){
            dp[i][0] = text1.charAt(i) == text2.charAt(0) ? 1 : dp[i - 1][0];
        }
        for(int j = 1; j < m; j++){
            dp[0][j] = text1.charAt(0) == text2.charAt(j) ? 1 : dp[0][j - 1];
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                dp[i][j] = text1.charAt(i) == text2.charAt(j) ? 1 + dp[i - 1][j - 1] : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n - 1][m - 1];
    }
}