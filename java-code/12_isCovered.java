class Solution {
    public String minWindow(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int n = s.length;
        int ansLeft = - 1;
        int ansRight = n;
        int left = 0;
        int[] cntS = new int[128];// s 子串字母的出现次数
        int[] cntT = new int[128];// t 中字母的出现次数
        for(char c: t){
            cntT[c] ++;
        }
        for(int right = 0; right < n; right++){
            cntS[s[right]] ++;// 右端点字母移入子串
            while(isCovered(cntS,cntT)){ // 涵盖
                if(right - left < ansRight - ansLeft){// 找到更短的子串
                    ansLeft = left;
                    ansRight = right;
                }
                cntS[s[left++]] --; // 左端点字母移出子串
            }
        }
        return ansLeft < 0 ? "" : S.substring(ansLeft,ansRight + 1);
    }
    private boolean isCovered(int[] cntS, int[] cntT){
        // 子串
        for(int i = 'A'; i <= 'Z'; i++){
            if(cntS[i] < cntT[i]){
                return false;
            }
        }
        for(int i = 'a'; i <= 'z'; i++){
            if(cntS[i] < cntT[i]){
                return false;
            }
        }
        return true;
    }
}