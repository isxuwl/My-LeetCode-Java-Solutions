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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rightHead = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return merge(left,right);
    }

    public ListNode merge(ListNode h1, ListNode h2){
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                p.next = h1;
                h1 = h1.next;
            }
            else{
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }
        if(h1 != null) p.next = h1;
        if(h2 != null) p.next = h2;
        return dummy.next;
    }
}