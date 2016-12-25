public class IntBinarySearchTree {
    private IntBinaryTreeNode root;

    public IntBinarySearchTree() {
        this.root = null;
    }

    public boolean search(int value) {
        IntBinaryTreeNode current = this.root;

        while (true) {
            if (current == null) {
                return false;
            }
            else if (value == current.value) {
                return true;
            }
            else if (value > current.value) {
                current = current.right;
            }
            else if (value < current.value) {
                current = current.left;
            }
        }
    }

    public void insert(int value) {
        if (this.root == null) {
            this.root = new IntBinaryTreeNode(value);
        }
        else {
            this.insertNode(this.root, value);
        }
    }

    private void insertNode(IntBinaryTreeNode node, int value) {
        if (value > node.value) {
            if (node.right == null) {
                node.right = new IntBinaryTreeNode(value);
            }
            else {
                this.insertNode(node.right, value);
            }
        }
        else if (value < node.value) {
            if (node.left == null) {
                node.left = new IntBinaryTreeNode(value);
            }
            else {
                this.insertNode(node.left, value);
            }
        }
        else {
            // 既に存在したら無視
            return;
        }
    }

    public boolean delete(int value) {
        IntBinaryTreeNode parent = this.root;
        IntBinaryTreeNode current = this.root;
        boolean isLeftNode = true;

        while (true) {
            if (current == null) {
                return false;
            }
            else if (value > current.value) {
                current = current.right;
                isLeftNode = false;
            }
            else if (value < current.value) {
                current = current.left;
                isLeftNode = true;
            }
            else if (value == current.value) {
                break;
            }
        }

        // 削除処理
        if (current.left == null) {
            if (current == this.root) {
                this.root = current.right;
            }
            else if (isLeftNode) {
                parent.left = current.right;
            }
            else {
                parent.right = current.right;
            }
        }
        else if (current.right == null) {
            if (current == this.root) {
                this.root = current.left;
            }
            else if (isLeftNode) {
                parent.left = current.left;
            }
            else {
                parent.right = current.left;
            }
        }
        else {
            // 両方の子があるとき
            parent = current;
            IntBinaryTreeNode left = current.left;
            isLeftNode = true;
            // 最大の子を探す
            while (left.right != null) {
                parent = left;
                left = left.right;
                isLeftNode = false;
            }
            current.value = left.value;
            if (isLeftNode) {
                parent.left = left.left;
            }
            else {
                parent.right = left.left;
            }
        }
        return true;
    }
}
