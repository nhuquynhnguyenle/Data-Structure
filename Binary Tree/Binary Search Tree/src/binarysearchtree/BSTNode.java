/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

/**
 *
 * @author Admin
 */
    public class BSTNode <T extends Comparable<T>>{
    protected T data;
    protected BSTNode<T> left,right;

    public BSTNode() {
        left = right = null;
    }

    public BSTNode(T data, BSTNode<T> left, BSTNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BSTNode(T data) {
        this(data,null,null);
    }
}

