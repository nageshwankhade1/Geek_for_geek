package com.nmw.tree.model;

import java.util.LinkedList;
import java.util.Queue;

public class InsertBinaryTree {

    static Node root;

    public InsertBinaryTree() {
        root = null;
    }

    public InsertBinaryTree(int key) {
        this.root = new Node(key);
    }

    public static void main(String[] args) {
        InsertBinaryTree tree = new InsertBinaryTree(10);
        tree.root.left = new Node(11);
        tree.root.left.left = new Node(7);
        tree.root.right = new Node(9);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(8);

        System.out.println("Before ----");

        traversalInOrder(tree.root);

        System.out.println("\nAfter ----");
        insertNode(tree.root,12);
        traversalInOrder(tree.root);
    }

    private static void insertNode(Node temp, int key) {
        if(temp ==null) root = new Node(temp.key);

        Queue queue = new LinkedList();
        queue.add(temp);

        while (!queue.isEmpty()) {

            temp = (Node) queue.peek();
            queue.remove();

            if(temp.left ==null){
                temp.left = new Node(key);
                break;
            }else {
                queue.add(temp.left);
            }

            if(temp.right == null){
                temp.right = new Node(key);
                break;
            }
            else{
                queue.add(temp.right);
            }
        }
    }

    private static void traversalInOrder(Node root) {

        if(root == null) return;

        traversalInOrder(root.left);
        System.out.print(root.key+" ");
        traversalInOrder(root.right);
    }
}
