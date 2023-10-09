package algorithm.linked;

import java.util.Arrays;
import java.util.List;

public class HasCycle_141 {
    public static void main(String[] args) {

        ListNode listNode = new ListNode(Arrays.asList(1, 3, 5, 6, 67, 32));
        List<ListNode> indexArr = listNode.getIndexArr();

        indexArr.get(indexArr.size() - 1).next = indexArr.get(2);
        boolean b = new HasCycle_141().hasCycle(listNode);
        System.out.println(b);
        assert b == true;
    }

    private boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
