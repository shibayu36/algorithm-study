public class IntBinaryTreeNode {
    public int value;
    public IntBinaryTreeNode left, right;

    public IntBinaryTreeNode(int value) {
        this.value = value;
        this.left = this.right = null;
    }

    public IntBinaryTreeNode maxNode() {
        IntBinaryTreeNode current = this;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }
}
