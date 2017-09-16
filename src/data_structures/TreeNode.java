package data_structures;

class TreeNode {
    Object data;
    TreeNode parent;
    TreeNode left;
    TreeNode right;

    public TreeNode(Object data) {
        this.data = data;
        this.parent = null;
        this.left = null;
        this.right = null;
    }
    
    public TreeNode(Object data, TreeNode parent, TreeNode left, TreeNode right) {
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}