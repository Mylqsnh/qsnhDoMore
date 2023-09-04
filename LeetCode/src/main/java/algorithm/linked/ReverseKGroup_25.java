package algorithm.linked;

import java.util.Arrays;

public class ReverseKGroup_25 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(Arrays.asList(1, 2, 3, 4, 5));
        ListNode result = new ReverseKGroup_25().reverseKGroup(listNode, 3);
        result.print();
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode b, a;
        b = a = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode newNode = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newNode;
    }

    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        return pre;
    }
}
