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
        BSTNode<T> node = root;
        while (node != null) {
            if (dataIn.equals(node.data)) {
                return node.data;
            } else if (dataIn.compareTo(node.data) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    public void breathFirst() throws InterruptedException {
        BSTNode<T> node = root;
        Queue<BSTNode<T>> queue = new Queue<BSTNode<T>>();
        if (node != null) {
            queue.enqueue(node);
            while (!queue.isEmpty()) {
                node = queue.dequeue();
                visit(node);
                if (node.left != null) {
                    queue.enqueue(node.left);
                }
                if (node.right != null) {
                    queue.enqueue(node.right);
                }
            }
        }
    }

    public void preOrder() {
        preOrder(this.root);
    }

    public void preOrder(BSTNode node) {
        if (node != null) {
            visit(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder() {
        inOrder(this.root);
    }

    public void inOrder(BSTNode node) {
        if (node != null) {
            preOrder(node.left);
            visit(node);
            preOrder(node.right);
        }
    }

    public void postOrder() {
        postOrder(this.root);
    }

    public void postOrder(BSTNode node) {
        if (node != null) {
            preOrder(node.left);
            preOrder(node.right);
            visit(node);
        }
    }

}
