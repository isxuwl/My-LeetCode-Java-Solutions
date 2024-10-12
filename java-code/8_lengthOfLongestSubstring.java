class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口
        Set<Character> set = new HashSet<>();
        int start = 0, res = 0;
        for(int i=0; i < s.length(); i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(start));
                start ++;
            }
            set.add(s.charAt(i));
            if(set.size() > res){
                res = set.size();
            }
        }
        return res;
    }
}