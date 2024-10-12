class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int n = s.length();
        for(int i = 0; i < n; i ++){
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for(int i = 0; i < n; i++){
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if(i == end){
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}