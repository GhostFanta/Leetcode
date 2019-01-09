/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode faker = new ListNode(0);
        faker.next = head;
        ListNode first = faker;
        while(n > -1 && first != null){
            first = first.next;
            --n;
        }
        ListNode second = faker;
        while(first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return faker.next;
    }
}
