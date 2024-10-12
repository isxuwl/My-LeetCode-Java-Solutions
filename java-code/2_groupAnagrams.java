class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //hashset哈希表
        Map<String,List<String>> hashmap = new HashMap<>();
        for(String str: strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            if(!hashmap.containsKey(key)){
                hashmap.put(key,new ArrayList());
            }
            hashmap.get(key).add(str);
        }
        return new ArrayList<>(hashmap.values());
    }
}