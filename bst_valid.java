import java.util.Stack;

public class bst_valid {

    public static class Node {
        int val;
        Node left;
        Node right;


        public Node(int val) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isValidBST(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        Integer prevValue = null;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            if (prevValue != null && curr.val <= prevValue) {
                return false;
            }

            prevValue = curr.val;
            curr = curr.right;
        }

        return true;
    }

    public static void main(String[] args) {

        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        System.out.println(isValidBST(root));

    }
}
