class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;
    Node insert(int data) {
        return new Node(data);
    }

    void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = tree.insert(10);
        tree.root.left = tree.insert(22);
        tree.root.right = tree.insert(83);
        tree.root.left.left = tree.insert(14);
        tree.root.left.right = tree.insert(35);

        System.out.print("Inorder traversal: ");
        tree.inorder(tree.root);
    }
}
