package algorithm.linked;

import java.util.Arrays;

public class ReverseBetween_92 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(Arrays.asList(1, 2, 3, 4, 5));
        ListNode listNode1 = new ReverseBetween_92().reverseBetween(listNode, 2, 4);
        listNode1.print();
    }

    static ListNode successor = null;

    public ListNode reverseBetween(ListNode head, int left, int right) {
         if (left == 1) {
             return reverseN(head, right);
         }
         head.next = reverseBetween(head.next, left - 1, right - 1);
         return head;
    }

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
           successor = head.next;
           return head;
        }

        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        head.next = successor;

        return last;
    }
}
