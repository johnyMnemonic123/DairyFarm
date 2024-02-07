package diaryfarm.farm.v2;


import java.util.Iterator;

public class TreeNode<T> {
    private T data;
    private MyLinkedList<TreeNode<T>> children;
    private TreeNode<T> parent;

    public TreeNode(T data) {
        this.data = data;
        this.children = new MyLinkedList<TreeNode<T>>();
    }


    public TreeNode(TreeNode<T> node) {
        this.data = node.getData();
        children = new MyLinkedList<>();
    }


    public void addChild(TreeNode<T> child) {
        child.setParent(this);
        children.insert(child);
    }


//    public void setChildren(MyLinkedList<Node<T>> children) {
//        for (Node<T> child : children)
//            child.setParent(this);
//
//        this.children = children;
//    }

    /**
     * Remove all children of this node.
     */
    public void removeChildren() {
        this.children.clear();
    }


    public void removeChild(TreeNode<T> childToBeDeleted) {
        MyLinkedList<TreeNode<T>> list = getChildren();
        list.deleteByPredicate(a -> a == childToBeDeleted);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getParent() {
        return this.parent;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public MyLinkedList<TreeNode<T>> getChildren() {
        return this.children;
    }

    public void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(getData());
        buffer.append('\n');
        for (var it = children.iterator(); it.hasNext() ;) {
            TreeNode<T> next = it.next();
            if (it.hasNext()) {
                next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }

        }
    }



}