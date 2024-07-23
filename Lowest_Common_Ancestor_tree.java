import java.util.*;
public class Lowest_Common_Ancestor_tree {

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    Node root;

    public Node findLCA(Node node, int n1, int n2) {
        if (node == null || node.val == n1 || node.val == n2) {
            return node;
        }

        Node leftLCA = findLCA(node.left, n1, n2);
        Node rightLCA = findLCA(node.right, n1, n2);

        if (leftLCA != null && rightLCA != null) {
            return node;
        }

        if (leftLCA != null) {
            return leftLCA;
        } else {
            return rightLCA;
        }
    }

    public static void main(String[] args) {
        Lowest_Common_Ancestor_tree tree;

        tree = new Lowest_Common_Ancestor_tree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        Scanner s = new Scanner(System.in);

        System.out.print("Enter first value (n1): ");
        int n1 = s.nextInt();
        System.out.print("Enter second value (n2): ");
        int n2 = s.nextInt();

        Node lca = tree.findLCA(tree.root, n1, n2);
        if (lca != null) {
            System.out.println("LCA(" + n1 + ", " + n2 + ") = " + lca.val);
        } else {
            System.out.println("No common ancestor for " + n1 + " and " + n2);
        }

        s.close();
    }
}
