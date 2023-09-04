package algorithm.linked;

import java.util.Arrays;

public class MergeTwoLists_21 {

    public static void main(String[] args) {
//        l1 = [1,2,4], l2 = [1,3,4]
        ListNode listNode = new MergeTwoLists_21().mergeTwoLists(
                new ListNode(Arrays.asList(1, 2, 4)),
                new ListNode(Arrays.asList(1, 3, 4, 5, 6)));

        listNode.print();
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode index = head;
        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                index.next = list1;
                list1 = list1.next;
            } else {
                index.next = list2;
                list2 = list2.next;
            }
            index = index.next;
        }

        if (list1 != null) {
            index.next = list1;
        }

        if (list2 != null) {
            index.next = list2;
        }

        return head.next;
    }
}
