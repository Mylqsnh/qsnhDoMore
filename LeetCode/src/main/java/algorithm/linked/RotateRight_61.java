package algorithm.linked;

import java.util.Arrays;

public class RotateRight_61 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(Arrays.asList(0, 1, 2));
        ListNode result = new RotateRight_61()
                .rotateRight(listNode, 4);
        result.print();
    }


    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }


    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || k == 0) return head;

        ListNode reverse = reverse(head);
        ListNode temp = new ListNode(-1);
        temp.next = reverse;
        ListNode pre, post;
        pre = reverse;
        post = null;

        for (int i = 1; i < k; i++) {
            if (pre.next != null) {
                pre = pre.next;
            } else {
                pre = reverse;
            }
        }
        if (pre != null && pre.next != null) {
            post = pre.next;
            pre.next = null;
            post = reverse(post);

        }
        pre = reverse(temp.next);
        temp.next.next = post;
        return pre;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
