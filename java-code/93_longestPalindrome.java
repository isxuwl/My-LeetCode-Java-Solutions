class Solution {
    public String longestPalindrome(String s) {
        // 中心扩散法
        int n = s.length();
        int maxStart = 0, maxLength = 0;
        for(int i = 0; i < n; i++){
            // j=0表示中心节点只有 i
            // j=1表示中心节点有两个 i，i+1
            for(int j = 0; j <= 1; j++){
                int l = i;
                int r = i + j;
                while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                    l --;
                    r ++;
                }
                l ++;
                r --;
                if(maxLength < r - l + 1){
                    maxLength = r - l + 1;
                    maxStart = l;
                }
            }
        }
        return s.substring(maxStart, maxStart + maxLength);
    }
}