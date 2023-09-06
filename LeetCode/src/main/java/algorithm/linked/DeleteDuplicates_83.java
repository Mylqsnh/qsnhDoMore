package algorithm.linked;

import java.util.Arrays;

public class DeleteDuplicates_83 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(Arrays.asList(1, 1, 2, 3, 3));
        ListNode result = new DeleteDuplicates_83().deleteDuplicates(listNode);
        result.print();
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode temp = head;
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return temp;
    }
}
