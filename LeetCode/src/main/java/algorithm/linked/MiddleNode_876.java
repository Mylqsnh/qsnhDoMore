package algorithm.linked;

import java.util.Arrays;

public class MiddleNode_876 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListNode listNode1 = middleNode(listNode);
        listNode1.print();
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
