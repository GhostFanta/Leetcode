/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next = head;

        ListNode base = fake;
        ListNode prev = head;
        ListNode now = head;

        boolean flag = false;

        while(now != null) {
            if(prev == now){
                now = now.next;
                continue;
            }
            // Find dup
            if(prev.val == now.val){
                now = now.next;
                // Set dup flag
                flag = true;
                continue;
            } else {
                if(flag){
                    // ignoe nodes from base to now
                    base.next = now;
                    // based on new point
                    if(now.next != null && now.next.val != now.val || now.next == null){
                        base = now;
                        flag = false;
                        // move prev to now
                        prev = now;
                    } else {
                        prev = now;
                    }
                } else {
                    // based on prev since now may be a dup
                    base = prev;
                    prev = now;
                }
            }

        }

        if(flag){
            base.next = now;
        }
        return fake.next;
    }
}
