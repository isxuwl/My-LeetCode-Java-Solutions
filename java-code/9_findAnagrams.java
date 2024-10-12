class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // 滑动窗口
        List<Integer> ans = new ArrayList<>();
        int n = s.length(), m = p.length();
        int[] c1 = new int[26], c2 = new int[26];
        for (int i = 0; i < m; i++) c2[p.charAt(i) - 'a']++;
        for (int l = 0, r = 0; r < n; r++) {
            c1[s.charAt(r) - 'a']++;
            if (r - l + 1 > m) c1[s.charAt(l++) - 'a']--;
            if (Arrays.equals(c1, c2)) ans.add(l);
        }
        return ans;
    }
}
