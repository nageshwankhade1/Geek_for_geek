import com.nmw.tree.model.Node;

import java.util.Stack;

public class TraversalBinaryTree {

    Node root;

    public TraversalBinaryTree() {
        root = null;
    }

    public TraversalBinaryTree(int key) {
        this.root = new Node(key);
    }

    public static void main(String[] args) {
        TraversalBinaryTree tree = new TraversalBinaryTree(10);
        tree.root.left = new Node(11);
        tree.root.left.left = new Node(7);
        tree.root.right = new Node(9);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(8);

        System.out.println("Inorder traversal before insertion:");
        //inorder(tree.root);
        inOrderStack(tree.root);
        System.out.println("\nInorder traversal after insertion:");
    }

    private static void inorderRecursively(Node root) {
        if (root == null) return;

        inorderRecursively(root.left);
        System.out.print(root.key+ " ");
        inorderRecursively(root.right);
    }

    private static  void inOrderStack(Node root){
        System.out.println("::Using stack::");
        Stack stack = new Stack();

        Node current = root;

        while (! stack.isEmpty() || current!= null) {

            if(current!=null){
                stack.push(current);
                current = current.left;
            }
            else {
                current = (Node) stack.pop();
                System.out.print(current.key+" ");
                current = current.right;
            }
        }
    }
}
