package algorithm.linked;

import java.util.Arrays;

public class RemoveNthFromEnd_19 {
    public static void main(String[] args) {
        ListNode listNode = removeNthFromEnd(new ListNode(Arrays.asList(1, 2, 3, 4, 5)), 2);
        listNode.print();
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        if (head == null || n == 0) {
            return head;
        }
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
