package algorithm.linked;

import java.util.Arrays;

public class Partition_86 {
    public static void main(String[] args) {
        //[1, 4, 3, 2, 5, 2]
        // 3
        ListNode listNode = new ListNode(Arrays.asList(1, 4, 3, 2, 5, 2));
        ListNode partition = new Partition_86().partition(listNode, 3);
        partition.print();
        listNode.print();
    }

    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(-1);
        ListNode head2 = new ListNode(-1);

        ListNode p1 = head1, p2 = head2;
        ListNode p = head;

        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = head2.next;
        return head1.next;
    }
}
