package algorithm.binaryTree;

public class Connect_116 {
    public static void main(String[] args) {
        Connect_116 connect116 = new Connect_116();
        connect116.work();
    }

    public void work() {
        Node node = new Node(1, new Node(2, new Node(4), new Node(5), null), new Node(3, new Node(6), new Node(7), null), null);
        Node connect = new Connect_116().connect(node);
    }

    public Node connect(Node root) {
        if (root == null) return null;
        traverse(root.left, root.right);
        return root;
    }

    void traverse(Node left, Node right) {
        if (left == null || right == null) return;

        left.next = right;

        traverse(left.left, left.right);
        traverse(right.left, right.right);
        traverse(left.right, right.left);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
