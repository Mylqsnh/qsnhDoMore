package algorithm.binaryTree;

public class LowestCommonAncestor_1650 {
    public static void main(String[] args) {

    }

    Node lowestCommonAncestor(Node p, Node q) {
        Node a = p, b = q;
        while (a != b) {
            if (a == null) a = q;
            else           a = a.parent;
            if (b == null) b = p;
            else           b = b.parent;
        }
        return a;
    }

}

class Node {
    int val;
    Node left;
    Node right;
    Node parent;
}
