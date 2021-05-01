package com.nmw.tree.model;

public class Node {

    int key;
    public Node left, right;

    public Node(int key){
        this.key = key;
        this.left = null;
        this.right = null;
    }
}
