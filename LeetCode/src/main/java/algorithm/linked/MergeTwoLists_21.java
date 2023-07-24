package algorithm.linked;

public class MergeTwoLists_21 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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

    public static void main(String[] args) {
//        l1 = [1,2,4], l2 = [1,3,4]
        ListNode listNode = mergeTwoLists(
                new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));

        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
            if (listNode != null) {
                System.out.print(" -> ");
            }
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
