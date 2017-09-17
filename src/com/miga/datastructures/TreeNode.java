package com.miga.datastructures;

class TreeNode<T extends Comparable<T>> {

    private T data;
    private TreeNode<T> parent;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public TreeNode(T data, TreeNode<T> parent, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return the parent
     */
    public TreeNode<T> getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    /**
     * @return the left
     */
    public TreeNode<T> getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public TreeNode<T> getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}