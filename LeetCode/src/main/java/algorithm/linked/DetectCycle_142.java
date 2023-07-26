package algorithm.linked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectCycle_142 {
    public static void main(String[] args) {

        ListNode listNode = new ListNode(Arrays.asList(1, 3, 5, 6, 67, 32));
        List<ListNode> indexArr = listNode.getIndexArr();

        indexArr.get(indexArr.size() - 1).next = indexArr.get(2);
        ListNode result = detectCycle(listNode);
        System.out.println(result.val);
        assert result.val == 5;
    }

    private static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;

        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
