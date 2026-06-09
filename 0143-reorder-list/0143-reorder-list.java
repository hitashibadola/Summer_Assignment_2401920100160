class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode k1 = head;
        ListNode k2 = prev;
        while (k2 != null) {
            ListNode temp1 = k1.next;
            ListNode temp2 = k2.next;
            k1.next = k2;
            k2.next = temp1;
            k1 = temp1;
            k2 = temp2;
        }
    }
}