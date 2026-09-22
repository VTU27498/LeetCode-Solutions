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
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // Step 1: store next
            curr.next = prev;          // Step 2: reverse pointer
            prev = curr;               // Step 3: move prev forward
            curr = next;               // Step 4: move curr forward
        }

        return prev; // new head
    }
}