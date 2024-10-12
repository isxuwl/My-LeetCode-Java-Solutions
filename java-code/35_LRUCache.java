class LRUCache {
    private int capacity;
    private HashMap<Integer,ListNode> hashmap;
    private ListNode head, tail;
    private class ListNode{
        int key, val;
        ListNode prev, next;
        public ListNode(){

        }
        public ListNode(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashmap = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }
    private void removeNode(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addNodeToLast(ListNode node){
        node.prev = tail.prev;
        node.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }
    private void moveNodeToLast(ListNode node){
        removeNode(node);
        addNodeToLast(node);
    }
    public int get(int key) {
        if(hashmap.containsKey(key)){
            ListNode node = hashmap.get(key);
            moveNodeToLast(node);
            return node.val;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(hashmap.containsKey(key)){
            ListNode node = hashmap.get(key);
            node.val = value;
            moveNodeToLast(node);
            return;
        }
        if(hashmap.size() == capacity){
            hashmap.remove(head.next.key);
            removeNode(head.next);
        }
        ListNode node = new ListNode(key,value);
        hashmap.put(key, node);
        addNodeToLast(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */