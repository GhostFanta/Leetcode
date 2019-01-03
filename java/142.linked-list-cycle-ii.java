/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode slow = head.next;
        ListNode fast = head.next;
        if(fast != null){
            fast = fast.next;
        } else {
            return null;
        }
        while(fast != null && slow != null){
            if(fast == slow){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            } else {
                return null;
            }
            slow = slow.next;
        }
        return null;
    }
}
