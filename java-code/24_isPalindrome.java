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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
             // 快指针每次前进两步
            fast = fast.next.next;
             // 每次循环将局部链表反转
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        // 1.偶数链表循环结束后，fast == null，
        // pre指向前半部分第一个回文数，slow指向后半部分第一个回文数
        // 2. 奇数链表循环结束后，fast !=null, fast.next == null
        // pre指向前半部分第一个回文数，slow指向后半部分第一个链表。
        // 要将slow向前推进一部
        //  用来判断回文链表是偶数还是奇数，
        //  如果回文链表是奇数（比如1->2->3->4->3->2->1）,
        //  这时候slow要从4到右边的三，
        //  如果是偶数（比如1->2->3->3>2->1）
        //  此时slow在第二个三
        if(fast != null){
            slow = slow.next;
        }
         // 此时pre指向前半部分第一个回文数，slow指向后半部分第一个回文数
        while(pre != null && slow != null){
            if(pre.val != slow.val){
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;

    }
}