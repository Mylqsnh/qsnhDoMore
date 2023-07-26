package algorithm.linked;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists_23 {
    public static void main(String[] args) {
        ListNode[] lists = {
                new ListNode(Arrays.asList(1, 4, 5)),
                new ListNode(Arrays.asList(1, 3, 4)),
                new ListNode(Arrays.asList(2, 6))};
        ListNode listNode = mergeKLists(lists);
        listNode.print();
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode p = head;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length,
                Comparator.comparingInt(a -> a.val));

        pq.addAll(Arrays.asList(lists));

        while (!pq.isEmpty()) {
            p.next = pq.poll();
            p = p.next;
            if (p.next != null) {
                pq.add(p.next);
            }
        }

        return head.next;
    }
}
