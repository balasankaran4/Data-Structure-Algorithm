import java.util.Scanner;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTreeByuser {
    Node root;
    Scanner sc=new Scanner(System.in);
    Node insert (int data){
        Node newNode=new Node (data); 
        newNode.left=newNode.right=null;
        return newNode;
    }
    Node Tree(){
        int data=sc.nextInt();
        if(data==-1) return null;
        return root;
    }
        void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTreeByuser t = new BinaryTreeByuser();
        System.out.println("Build the binary tree:");
        t.root = t.buildTree(sc, "root");

        System.out.print("Inorder traversal: ");
        t.inorder(t.root);
        System.out.println();

        sc.close();
    }
}
