import java.util.*;
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTreeusingRecrosion{
	Scanner sc=new Scanner(System.in);
    Node root;
    Node insert(int data) {
        Node newNode=new Node(data);
		
		newNode.left=newNode.right=null;
        return newNode;
    }
      Node tree;
    void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeusingRecrosion tree = new BinaryTreeusingRecrosion();

        tree.root = tree.insert(10);
        tree.root.left = tree.insert(22);
        tree.root.right = tree.insert(83);
        tree.root.left.left = tree.insert(14);
        tree.root.left.right = tree.insert(35);

        System.out.print("Inorder traversal: ");
        tree.inorder(tree.root);
    }
}
