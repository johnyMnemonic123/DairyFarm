package diaryfarm.farm.v2;

import java.util.function.Predicate;

public class Tree<T> {
    private TreeNode<T> root;

    public Tree(TreeNode<T> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }


    public boolean exists(T key) {
        return find(root, key);
    }


    public int size() {
        return getNumberOfDescendants(root) + 1;
    }

    public int getNumberOfDescendants(TreeNode<T> TreeNode) {
        int n = TreeNode.getChildren().size();
        for (TreeNode<T> child : TreeNode.getChildren())
            n += getNumberOfDescendants(child);

        return n;

    }

    public boolean find(TreeNode<T> TreeNode, T toFind) {
        boolean res = false;
        if (TreeNode.getData().equals(toFind))
            return true;

        else {
            for (TreeNode<T> child : TreeNode.getChildren())
                if (find(child, toFind))
                    res = true;
        }

        return res;
    }

    public TreeNode<T> findTreeNode(TreeNode<T> TreeNode, T toFind) {
        if (TreeNode == null)
            return null;
        if (TreeNode.getData().equals(toFind))
            return TreeNode;
        else {
            TreeNode<T> cTreeNode = null;
            for (TreeNode<T> child : TreeNode.getChildren())
                if ((cTreeNode = findTreeNode(child, toFind)) != null)
                    return cTreeNode;
        }
        return null;
    }
    public TreeNode<T> findTreeNode(TreeNode<T> TreeNode, Predicate<T> toFind) {
        if (TreeNode == null)
            return null;
        if (toFind.test(TreeNode.getData()))
            return TreeNode;
        else {
            TreeNode<T> cTreeNode = null;
            for (TreeNode<T> child : TreeNode.getChildren())
                if ((cTreeNode = findTreeNode(child, toFind)) != null)
                    return cTreeNode;
        }
        return null;
    }

    public String print() {
        StringBuilder buffer = new StringBuilder();
        root.print(buffer, "", "");
        return buffer.toString();
    }

}