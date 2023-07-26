package algorithm.linked;

import java.util.Arrays;

public class RemoveNthFromEnd_19 {
    public static void main(String[] args) {
        ListNode listNode = removeNthFromEnd(new ListNode(Arrays.asList(1, 2, 3, 4, 5)), 2);
        listNode.print();
    }

    private static ListNode removeNthFromEnd(ListNode listNode, int x) {
        ListNode head = new ListNode(-1);
        head.next = listNode;

        ListNode fromEnd = findFromEnd(listNode, x + 1);
        fromEnd.next = fromEnd.next.next;

        return head.next;
    }

    private static ListNode findFromEnd(ListNode listNode, int x) {
        ListNode p1 = listNode;
        ListNode p2 = listNode;

        for (int i = 0; i < x; i++) {
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }
}
