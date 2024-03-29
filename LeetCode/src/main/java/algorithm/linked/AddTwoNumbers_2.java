package algorithm.linked;

import java.util.Arrays;

public class AddTwoNumbers_2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(Arrays.asList(9, 9, 7));
        ListNode l2 = new ListNode(8);
        ListNode listNode = new AddTwoNumbers_2().addTwoNumbers(l1, l2);
        listNode.print();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;

            int sum = n1 + n2 + carry;

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            carry = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return head;
    }
}