package com.miga.datastructures;

import java.lang.Math;

public class BinarySearchTree<T extends Comparable<T>> {

    private TreeNode<T> root;
    private int size;
    private int depth;

    BinarySearchTree() {
        root = null;
        size = 0;
        depth = 0;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public int getDepth(TreeNode<T> node) {
        if (node == null)
            return 0;

        int leftDepth = getDepth(node.getLeft());
        int rightDepth = getDepth(node.getRight());

        return (leftDepth > rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
    }

    public Object getData(TreeNode<T> node) {
        return node.getData();
    }

    public void insert(T data) {
        if (root == null) {
            root = new TreeNode<T>(data);
            depth++;
        } else {
            TreeNode<T> current = root;
            TreeNode<T> parent = null;

            while (current != null) {
                if (data.compareTo(current.getData()) < 1) {
                    parent = current;
                    current = current.getLeft();
                } else {
                    parent = current; 
                    current = current.getRight();
                }
            }

            TreeNode<T> newNode = new TreeNode<T>(data, parent, null, null);
            if (data.compareTo(parent.getData()) < 1) {
                parent.setLeft(newNode);
            } else {
                parent.setRight(newNode);
            }
        }
        size++;
    }

    public void insert(TreeNode<T> node, T data) {
        if (node == null) {
            root = new TreeNode<T>(data);
            size++;
        }

        if (data.compareTo(node.getData()) < 1) {
            if (node.getLeft() == null) {
                TreeNode<T> newNode = new TreeNode<T>(data, node, null, null);
                node.setLeft(newNode);
                size++;
            } else {
                insert(node.getLeft(), data);
            }
        } else {
            if (node.getRight() == null) {
                TreeNode<T> newNode = new TreeNode<T>(data, node, null, null);
                node.setRight(newNode);
                size++;
            } else {
                insert(node.getRight(), data);
            }
        }
    }

    public void printPreOrder(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData());
        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());
    }

    public void printInOrder(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        printInOrder(node.getLeft());
        System.out.print(node.getData());
        printInOrder(node.getRight());
    }

    public void printPostOrder(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.getLeft());
        printPostOrder(node.getRight());
        System.out.print(node.getData());
    }

    public void printLevelOrder() {
        Queue<T> queueData = new Queue<T>();
        Queue<TreeNode<T>> queueNode = new Queue<TreeNode<T>>();

        if (root == null)
            return;

        queueNode.enqueue(root);
        this.depth = getDepth(root);
        int depth = 0;

        while (depth < this.depth) {
            for (int i = 0; i < Math.pow(2, depth); i++) {
                TreeNode<T> current = queueNode.dequeue();
                if (current == null) {
                    queueData.enqueue(null);
                    queueNode.enqueue(null);
                    queueNode.enqueue(null);
                } else {
                    queueData.enqueue(current.getData());
                    queueNode.enqueue(current.getLeft());
                    queueNode.enqueue(current.getRight());
                }

                for (int j = 0; j < Math.pow(2, this.depth - depth - 1) - 1; j++) {
                    System.out.print(" ");
                }

                T data = queueData.dequeue();
                if (data != null)
                    System.out.print(data);
                else
                    System.out.print("*");

                for (int j = 0; j < Math.pow(2, this.depth - depth - 1); j++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            depth++;
        }
        System.out.println();
    }

    public boolean search(TreeNode<T> node, T data) {
        if (node == null) {
            return false;
        }

        if (data.compareTo(node.getData()) == -1) {
            search(node.getLeft(), data);
        } else if (data.compareTo(node.getData()) == 1) {
            search(node.getRight(), data);
        } else {
            return true;
        }
        return false;
    }

    public boolean delete(TreeNode<T> node, T data) {
        if (node == null) {
            return false;
        }

        if (data.compareTo(node.getData()) == -1) {
            delete(node.getLeft(), data);
        } else if (data.compareTo(node.getData()) == 1) {
            delete(node.getRight(), data);
        } else {
            // leaf node
            if (node.getLeft() == null && node.getRight() == null) {
                if (node == root) {
                    root = null;
                } else {
                    if (node == node.getParent().getLeft()) {
                        node.getParent().setLeft(null);
                    } else {
                        node.getParent().setRight(null);
                    }
                }
                // node = null;
                size--;
                return true;
            // node has only left child
            } else if (node.getLeft() != null && node.getRight() == null) {
                if (node == root) {
                    root = root.getLeft();
                } else {
                    // node is a left child
                    if (node == node.getParent().getLeft()) {
                        node.getParent().setLeft(node.getLeft());
                        node.getLeft().setParent(node.getParent());
                    // node is a right child
                    } else {
                        node.getParent().setRight(node.getLeft());
                        node.getLeft().setParent(node.getParent());
                    }
                }
                // node = null;
                size--;
                return true;
            // node has only right child
            } else if (node.getLeft() == null && node.getRight() != null) {
                if (node == root) {
                    root = root.getRight();
                } else {
                    // node is a left child
                    if (node == node.getParent().getLeft()) {
                        node.getParent().setLeft(node.getRight());
                        node.getRight().setParent(node.getParent());
                    // node is a right child
                    } else {
                        node.getParent().setRight(node.getRight());
                        node.getRight().setParent(node.getParent());
                    }
                }
                // node = null;
                size--;
                return true;
            // node has both left and right children
            } else {
                TreeNode<T> current = node.getLeft();
                while (current.getRight() != null) {
                    current = current.getRight();
                }

                node.setData(current.getData());
                // node is a left child
                if (current == node.getLeft()) {
                    node.setLeft(current.getLeft());
                // node is a right child
                } else {
                    current.getParent().setRight(current.getLeft());
                }
                node = null;
                size--;
                return true;
            }
        }
        return false;
    }
}