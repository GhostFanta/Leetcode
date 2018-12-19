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

        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();

        ListNode h1 = l1;
        ListNode h2 = l2;

        while(h1 != null){
            a.push(h1.val);
            h1 = h1.next;
        }

        while(h2 != null){
            b.push(h2.val);
            h2 = h2.next;
        }

        ListNode head = new ListNode(0);
        int carry = 0;
        while(!a.isEmpty() || !b.isEmpty()){
            int cur = carry;
            if(!a.isEmpty()){
                cur += a.pop();
            }

            if(!b.isEmpty()){
                cur += b.pop();
            }

            int val = cur % 10;
            carry = cur / 10;
            ListNode temp = new ListNode(val);
            temp.next = head.next;
            head.next = temp;
        }

        if(carry != 0){
            ListNode temp = new ListNode(carry);
            temp.next = head.next;
            head.next = temp;
        }
        return head.next;
    }
}
