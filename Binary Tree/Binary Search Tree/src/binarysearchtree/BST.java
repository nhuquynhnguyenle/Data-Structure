/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

import sun.misc.Queue;

/**
 *
 * @author Admin
 */
public class BST<T extends Comparable<T>> {

    /**
     * @param args the command line arguments
     */
    protected BSTNode<T> root = null;

    public BST() {
    }

    void visit(BSTNode<T> node) {
        System.out.println(node.data + "");
    }

    public T search(T dataIn) {
        BSTNode<T> root = this.root;
        while (root != null) {
            if (dataIn.equals(root.data)) {
                return root.data;
            } else if (dataIn.compareTo(root.data) < 0) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }

    public void breathFirst() throws InterruptedException {
        BSTNode<T> root = this.root;
        Queue<BSTNode<T>> queue = new Queue<BSTNode<T>>();
        if (root != null) {
            queue.enqueue(root); // them node vao queue
            while (!queue.isEmpty()) { //dung khi queue la rong
                root = queue.dequeue();
                visit(root);
                if (root.left != null) { //co con trai
                    queue.enqueue(root.left);
                }
                if (root.right != null) { //co con phai
                    queue.enqueue(root.right);
                }
            }
        }
    }

    public void preOrder() {
        preOrder(this.root);
    }

    public void preOrder(BSTNode root) {
        if (root != null) {
            visit(root);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder() {
        inOrder(this.root);
    }

    public void inOrder(BSTNode root) {
        if (root != null) {
            preOrder(root.left);
            visit(root);
            preOrder(root.right);
        }
    }

    public void postOrder() {
        postOrder(this.root);
    }

    public void postOrder(BSTNode root) {
        if (root != null) {
            preOrder(root.left);
            preOrder(root.right);
            visit(root);
        }
    }

    public void insert(T dataIn) {
        BSTNode<T> root = this.root;
        BSTNode<T> prev = null;
        while (root != null) {  //find a place for inserting new node
            prev = root;
            if (dataIn.compareTo(root.data) < 0) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        if (root == null) { //tree is empty
            root = new BSTNode<T>(dataIn);
        } else if (dataIn.compareTo(root.data) < 0) {
            prev.left = new BSTNode<T>(dataIn);
        } else {
            prev.right = new BSTNode<T>(dataIn);
        }
    }

    public void deleteByMerge(T dataIn) {
        BSTNode<T> temp, node, root = this.root, prev = null;
        while (root != null && !root.data.equals(dataIn)) {  //fimd the node p with element dataIn
            prev = root;
            if (dataIn.compareTo(root.data) < 0) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        node = root;
        if (root != null && dataIn.equals(root.data)) {  //
            if (node.right == null) {
                node = node.left;
            } else if (node.left == null) {
                node = node.right;
            } else {
                temp = node.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = node.right;
            }
        }
    }
}
