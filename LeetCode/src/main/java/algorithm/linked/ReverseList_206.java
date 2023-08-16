package algorithm.linked;

import java.util.Arrays;

public class ReverseList_206 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(Arrays.asList(1, 2, 3, 4, 5));
        ListNode listNode1 = reverseList(listNode);
        listNode1.print();
    }


    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }

}
