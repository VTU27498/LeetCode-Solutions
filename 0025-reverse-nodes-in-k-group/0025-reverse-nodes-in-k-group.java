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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevGroupStart = dummy;

        while (true) {
            // Step 1: Find kth node
            ListNode kth = prevGroupStart;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) break; // not enough nodes left

            // Step 2: Define group boundaries
            ListNode groupStart = prevGroupStart.next;
            ListNode nextGroupStart = kth.next;

            // Step 3: Reverse the group
            ListNode prev = nextGroupStart;
            ListNode current = groupStart;
            while (current != nextGroupStart) {
                ListNode nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }

            // Step 4: Connect reversed group
            prevGroupStart.next = kth;
            prevGroupStart = groupStart;
        }

        return dummy.next;
    }
}