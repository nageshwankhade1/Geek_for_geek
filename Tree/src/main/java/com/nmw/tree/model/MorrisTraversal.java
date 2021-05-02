package com.nmw.tree.model;

public class MorrisTraversal {
    Node root;

    public MorrisTraversal() {
        root=null;
    }

    public MorrisTraversal(int key) {
        this.root = new Node(key);
    }

    public static void main(String[] args) {

        MorrisTraversal tree = new MorrisTraversal(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(12);
        tree.root.left.left.right = new Node(13);
        tree.root.left.right.left = new Node(16);
        tree.root.left.right.right = new Node(14);
        tree.root.left.right.right.right = new Node(17);



        morrisTraversal(tree.root);
    }

    private static void morrisTraversal(Node root) {

        Node current, pre;

        if(root==null){
            return;
        }

        current =root;

        while (current!=null){

            if(current.left==null){
                System.out.print(current.key+" ");
                current = current.right;
            }
            else {
                //Find inorder predecessor of current
                pre = current.left;

                while(pre.right!=null && pre.right!=current){
                    pre = pre.right;
                }// End of while loop

                //Make current as right child of its inorder predecessor
                if(pre.right == null){
                    pre.right = current;
                    current = current.left;
                }else {
                 //Revert the changes made in the 'if' part
                    // to restore the original
                    // tree i.e., fix the right child of predecessor
                    pre.right = null;
                    System.out.print(current.key+ " ");
                    current = current.right;
                }//End of if condition pre->right == NULL
            }//End of if condition current->left == NULL
        }//End of While

    }//End of method
}
