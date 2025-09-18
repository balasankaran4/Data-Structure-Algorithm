import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTreeMini {
    Scanner sc = new Scanner(System.in);
    Node root;

    Node insert(int data) {
        Node newNode = new Node(data);
        newNode.left = newNode.right = null;
        return newNode;
    }

    void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    int findMin(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    public static void main(String[] args) {
        BinaryTreeMini tree = new BinaryTreeMini();

        tree.root = tree.insert(10);
        tree.root.left = tree.insert(22);
        tree.root.right = tree.insert(83);
        tree.root.left.left = tree.insert(14);
        tree.root.left.right = tree.insert(35);

        System.out.print("Inorder traversal: ");
        tree.inorder(tree.root);
        System.out.println();

        int minValue = tree.findMin(tree.root);
        System.out.println("Minimum value in the tree: " + minValue);
    }
}