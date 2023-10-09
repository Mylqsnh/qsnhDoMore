package algorithm.linked;

import java.util.Arrays;

public class IsPalindrome_234 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(Arrays.asList(1, 2, 2, 1));
        boolean palindrome = new IsPalindrome_234().isPalindrome(listNode);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;

        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = reverse(slow);

        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
