/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        ListNode start = head;
        ListNode tag = start;
        int len = 0;
        while(start != null){
            if(start.next == null){
                tag = start;
            }
            start = start.next;
            len++;
        }
        tag.next = head;
        k %= len;
        k = len - k;
        while(k > 0){
            tag = tag.next;
            k--;
        }
        head = tag.next;
        tag.next = null;
        return head;
    }
}
