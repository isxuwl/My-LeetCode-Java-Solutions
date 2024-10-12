class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder strb = new StringBuilder();
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                num = num * 10 + (c - '0');
            }else if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                strb.append(c);
            }else if(c == '['){
                if(num > 0) numStack.push(num);
                strStack.push(strb.toString());
                strb = new StringBuilder();
                num = 0;
            }else{//c = ']'
                StringBuilder finStrb = new StringBuilder().append(strStack.pop());
                int times = numStack.pop();
                for(int k = 0; k < times; k++){
                    finStrb.append(strb);
                }
                strb = finStrb;
            }
        }
        return strb.toString();
    }
}