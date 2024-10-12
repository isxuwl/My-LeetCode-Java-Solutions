/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1,o2) -> o1.val - o2.val);
        for(ListNode node: lists){
            if(node != null){
                pq.add(node);
            }
        }
        ListNode dummy = new ListNode(-1);
    head = dummy;
        while(!pq.isEmpty()){
            head.next = pq.poll();
            head = head.next;
            if(head.next != null){
                pq.add(head.next);
            }
        }
        return dummy.next;
    }
}