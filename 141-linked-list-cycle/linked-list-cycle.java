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
class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;         // Moves 1 step at a time
        ListNode fast = head.next;    // Moves 2 steps at a time

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false; // Reached end, no cycle
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true; // fast and slow met -> cycle exists
    }
}
