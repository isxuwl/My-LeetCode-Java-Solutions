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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy, end = dummy;
        while(end != null){
            for(int i = 0; i < k && end != null; i++){
                end = end.next;
            }
            if(end == null) break;

            ListNode start = pre.next;
            ListNode headNext = end.next;
            end.next = null;
            pre.next = reverse(start);
            
            start.next = headNext;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}