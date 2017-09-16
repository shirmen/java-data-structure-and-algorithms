package data_structures;

import java.lang.Math;

public class BinarySearchTree {
    private TreeNode root;
    private int size;
    private int depth;

    BinarySearchTree() {
        root = null;
        size = 0;
        depth = 0;
    }

    public TreeNode getRoot() {
        return root;
    }
    
    public int getSize() {
        return size;
    }
    
    public int getDepth(TreeNode node) {
        if (node == null)
            return 0;
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        return (leftDepth > rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
    }

    public Object getData(TreeNode node) {
        return node.data;
    }
    
    public void insert(Object data) {
        if (root == null) {
            root = new TreeNode(data);
            depth++;
        } else {
            TreeNode current = root;
            TreeNode parent = null;
            
            while (current != null) {
                if ((Integer) data <= (Integer) current.data) {
                    parent = current;
                    current = current.left;
                } else {
                    parent = current; 
                    current = current.right;
                }
            }
            
            TreeNode newNode = new TreeNode(data, parent, null, null);

            if ((Integer) data <= (Integer) parent.data) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        }        
        size++;
    }

    public void insert(TreeNode node, Object data) {
        if (node == null) {
            root = new TreeNode(data);
            size++;
            return;
        }
        
        if ((Integer)data <= (Integer)node.data) {
            if (node.left == null) {
                TreeNode newNode = new TreeNode(data, node, null, null);
                node.left = newNode;
                size++;
            } else {
                insert(node.left, data);
            }
        } else {
            if (node.right == null) {
                TreeNode newNode = new TreeNode(data, node, null, null);
                node.right = newNode;
                size++;
            } else {
                insert(node.right, data);
            }
        }
        return;
    }

    public void printPreOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data);
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.data);
        printInOrder(node.right);
    }

    public void printPostOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data);
    }
    
    public void printLevelOrder() {
        MyQueue<Object> queueData = new MyQueue<Object>();
        MyQueue<TreeNode> queueNode = new MyQueue<TreeNode>();
        
        if (root == null)
            return;
        
        queueNode.enqueue(root);
        this.depth = getDepth(root);
        int depth = 0;
                
        while (depth < this.depth) {
            for (int i = 0; i < Math.pow(2, depth); i++) {
                TreeNode current = queueNode.dequeue();
                if (current == null) {
                    queueData.enqueue(null);
                    queueNode.enqueue(null);
                    queueNode.enqueue(null);
                } else {
                    queueData.enqueue(current.data);
                    queueNode.enqueue(current.left);
                    queueNode.enqueue(current.right);
                }

                for (int j = 0; j < Math.pow(2, this.depth - depth - 1) - 1; j++) {
                    System.out.print(" ");
                }
                Object data = queueData.dequeue();
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
    
    MyQueue<Integer> queue = new MyQueue<Integer>();
    public boolean search(TreeNode node, Object data) {
        if (node == null) {
            return false;
        }

        if ((Integer)data < (Integer)node.data) {
            queue.enqueue(1);
            search(node.left, data);
        } else if ((Integer)data > (Integer)node.data) {
            queue.enqueue(0);
            search(node.right, data);
        } else {
            queue.display();
            // System.out.println("search: " + node.data);
            return true;
        }
        return false;
    }
    
    public boolean delete(TreeNode node, Object data) {
        if (node == null) {
            return false;
        }

        if ((Integer)data < (Integer)node.data) {
            delete(node.left, data);
        } else if ((Integer)data > (Integer)node.data) {
            delete(node.right, data);
        } else {
            // leaf node
            if (node.left == null && node.right == null) {
                if (node == root) {
                    root = null;
                } else {
                    if (node == node.parent.left) {
                        node.parent.left = null;
                    } else {
                        node.parent.right = null;
                    }
                }
                // node = null;
                size--;
                return true;
            // node has left child only
            } else if (node.left != null && node.right == null) {
                if (node == root) {
                    root = root.left;
                } else {
                    // node is left child
                    if (node == node.parent.left) {
                        node.parent.left = node.left;
                        node.left.parent = node.parent;
                    // node is right child
                    } else {
                        node.parent.right = node.left;
                        node.left.parent = node.parent;
                    }
                }
                // node = null;
                size--;
                return true;
            // node has right child only
            } else if (node.left == null && node.right != null) {
                if (node == root) {
                    root = root.right;
                } else {
                    // node is left child
                    if (node == node.parent.left) {
                        node.parent.left = node.right;
                        node.right.parent = node.parent;
                    // node is right child
                    } else {
                        node.parent.right = node.right;
                        node.right.parent = node.parent;
                    }
                }
                // node = null;
                size--;
                return true;
            // node has both childs
            } else {
                TreeNode current = node.left;
                while (current.right != null) {
                    current = current.right;
                }
                node.data = current.data;
                // node is left child
                if (current == node.left) {
                    node.left = current.left;
                // node is right child
                } else {
                    current.parent.right = current.left;
                }
                node = null;
                size--;
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        BinarySearchTree bstree = new BinarySearchTree();

        bstree.insert(9);
        bstree.printLevelOrder();
        bstree.insert(7);
        bstree.printLevelOrder();
        bstree.insert(11);
        bstree.printLevelOrder();
        bstree.insert(6);
        bstree.printLevelOrder();
        bstree.insert(8);
        bstree.printLevelOrder();
        bstree.insert(10);
        bstree.printLevelOrder();
        bstree.insert(12);
        bstree.printLevelOrder();
        bstree.insert(3);
        bstree.printLevelOrder();
        bstree.insert(6);
        bstree.printLevelOrder();
        bstree.insert(3);
        bstree.printLevelOrder();
        bstree.insert(16);
        bstree.printLevelOrder();
        bstree.insert(18);
        bstree.printLevelOrder();
        bstree.insert(14);
        bstree.printLevelOrder();
        bstree.insert(1);
        bstree.printLevelOrder();
        bstree.insert(2);
        bstree.printLevelOrder();
        bstree.insert(0);
        bstree.printLevelOrder();
        // bstree.insert(11);
        // bstree.insert(26);
        // bstree.insert(20);
        // bstree.insert(15);
        // bstree.insert(25);
        bstree.printLevelOrder();
        
        bstree.delete(bstree.getRoot(), 7);
        System.out.println("====7====");
        bstree.printLevelOrder();

        bstree.delete(bstree.getRoot(), 11);
        System.out.println("====11====");
        bstree.printLevelOrder();

        bstree.delete(bstree.getRoot(), 9);
        System.out.println("====9====");
        bstree.printLevelOrder();

        System.out.println(bstree.getDepth(bstree.getRoot()));

        // bstree.insert(0);
        // bstree.insert(3);
        // bstree.insert(13);
        // bstree.printLevelOrder();

        // bstree.search(bstree.getRoot(), 12);

        // bstree.printPreOrder(bstree.getRoot());
        // System.out.println();
        // bstree.printInOrder(bstree.getRoot());
        // System.out.println();
        // bstree.printPostOrder(bstree.getRoot());
        // System.out.println();

    }
}