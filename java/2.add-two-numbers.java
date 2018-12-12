/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ? l2 == null ? l1 : l2 : l1;
        }
        int carry = 0;
        ListNode faker = new ListNode(0);
        ListNode head = faker;
        while(l1 != null || l2 != null){
            int nodeval = l1 == null ? l2.val + carry : l2 == null ? l1.val + carry : l1.val +  l2.val + carry;
            head.next = new ListNode(nodeval % 10);
            carry = nodeval / 10;
            head = head.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(carry != 0){
            head.next = new ListNode(carry);
        }

        return faker.next;
    }
}
