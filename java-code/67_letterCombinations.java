class Solution {
    List<String> res = new ArrayList<>();
    StringBuffer path = new StringBuffer();
    Map<Character,String> phoneMap = new HashMap<>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return res;
        }
        backtrack(digits, 0);
        return res;
    }
    private void backtrack(String digits, int idx){
        if(idx == digits.length()){
            res.add(path.toString());
            return;
        }
        char c = digits.charAt(idx);
        String letter = phoneMap.get(c);
        for(int i =0; i < letter.length(); i++){
            path.append(letter.charAt(i));
            backtrack(digits, idx + 1);
            path.deleteCharAt(idx);
        }
    }
}