package DS.tree;

import Util.Node;

import java.util.Stack;

public class Traversal {

    public void inOrderRecursive(Node root) {
        if (root != null) {
            inOrderRecursive(root.left);
            System.out.println(root.data);
            inOrderRecursive(root.right);
        }
    }

    public void preOrderRecursive(Node root) {
        if (root != null) {
            System.out.println(root.data);
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }

    public void postOrderRecursive(Node root) {
        if (root != null) {
            postOrderRecursive(root.left);
            postOrderRecursive(root.right);
            System.out.println(root.data);
            ;
        }
    }

    public void inOrderIterativeWithStack(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            Node curr = stack.pop();
            while (curr != null || !stack.isEmpty()) {

                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;

                }
                Node temp = stack.pop();
                System.out.println(temp.data);
                curr = curr.right;

            }
        }
    }

    public Node inOrderSuccessor(Node root, Node x) {
        //case 1 : root.right is not null
        if (x.right != null) {
            return leftMostNode(x.right);
        } else {
            Node rightMost = rightMostNode(root);
            if (rightMost == x)
                return null;// no successor of rightmost node
            return findInOrderRecursive(root, x);
        }
    }

    private Node findInOrderRecursive(Node root, Node x) {
        if (root == null) {
            return null;
        }
        Node temp = null;
        if (root == x || (temp = findInOrderRecursive(root.left, x)) != null || (temp = findInOrderRecursive(root.right, x)) != null) {

            if (root.left == temp) {
                return root;
            }
        }
        return temp;

    }

    private Node leftMostNode(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private Node rightMostNode(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}
