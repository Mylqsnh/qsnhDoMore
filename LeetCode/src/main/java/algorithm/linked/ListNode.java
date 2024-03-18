package algorithm.linked;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ArrayList<ListNode> indexArr;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(List<Integer> list) {
        ListNode head = new ListNode(-1);
        ListNode point = head;
        for (int i : list) {
            point.next = new ListNode(i);
            point = point.next;
        }
        this.next = head.next.next;
        this.val = head.next.val;
    }

    public void print() {
        ListNode head = new ListNode(-1, this);
        ListNode point = head;

        while (point.next != null) {
            System.out.print(point.next.val);
            point = point.next;
            if (point.next != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public List<ListNode> getIndexArr() {
        if (this.indexArr == null) {
            this.indexArr = new ArrayList<>();
            ListNode p = this;
            while (p != null) {
                indexArr.add(p);
                p = p.next;
            }
        }

        return this.indexArr;
    }
}