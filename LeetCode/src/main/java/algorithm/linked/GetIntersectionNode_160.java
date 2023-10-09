package algorithm.linked;

import java.util.Arrays;
import java.util.List;

public class GetIntersectionNode_160 {
    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(Arrays.asList(1, 3, 5, 6, 67, 32));
        List<ListNode> indexArr1 = listNode1.getIndexArr();

        ListNode listNode2 = new ListNode(Arrays.asList(7, 46, 14));
        List<ListNode> indexArr2 = listNode2.getIndexArr();
        indexArr2.get(indexArr2.size() - 1).next = indexArr1.get(3);

        ListNode intersectionNode = new GetIntersectionNode_160().getIntersectionNode(listNode1, listNode2);
        System.out.println(intersectionNode.val);
        assert intersectionNode.val == 6;
    }

    private ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        ListNode p1 = head1;
        ListNode p2 = head2;

        while (p1 != p2) {
            if (p1 == null) {
                p1 = head2;
            } else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = head1;
            } else {
                p2 = p2.next;
            }
        }

        return p1;
    }
}
