class Solution {
    public boolean isValid(String s) {
        if(s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else if(stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}