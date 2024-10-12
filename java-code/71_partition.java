class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s.toCharArray(), 0, new ArrayList());
        return ans;
    }
    private void backtrack(char[] s, int startIndex, List<String> path){
        if(startIndex == s.length){
            ans.add(new ArrayList(path));
            return;
        }
        for(int i = startIndex; i < s.length; i++){
            //从startIndex到i如果是回文串，则将此串加入path，并向下递归
            if(check(s, startIndex, i)){
                path.add(new String(s, startIndex, i - startIndex + 1));
                backtrack(s, i + 1, path);
                path.removeLast();
            }
        }
    }
    private boolean check(char[] s, int start, int end){
        while(start <= end){
            if(s[start ++] != s[end --]){
                return false;
            }
        }
        return true;
    }
}