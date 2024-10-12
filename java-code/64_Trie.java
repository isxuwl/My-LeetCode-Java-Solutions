class Trie {
    class TrieNode{
        boolean val;
        TrieNode[] children = new TrieNode[26];
    }
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode p = root;
        for(char c: word.toCharArray()){
            int i = c - 'a';
            if(p.children[i] == null) p.children[i] = new TrieNode();
            p = p.children[i];
        }
        p.val = true;
    }
    
    public boolean search(String word) {
        TrieNode p = root;
        for(char c: word.toCharArray()){
            int i = c - 'a';
            if(p.children[i] == null) return false;
            p = p.children[i];
        }
        return p.val;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for(char c: prefix.toCharArray()){
            int i = c - 'a';
            if(p.children[i] == null) return false;
            p = p.children[i];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */