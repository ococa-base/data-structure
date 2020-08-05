package BTS;

import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E>> {

    // 内部类
    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    // 成员属性
    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 像二分搜索树中插入元素e
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        // 终止条件
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if(e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }
        return node;
    }

    // 查找二分搜索树中是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.equals(node.e)) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    // 层序遍历
    public void levelTravel() {
//        st
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        if (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);

            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }

    public E maximum() {
        if(size == 0) { throw new IllegalArgumentException("size == 0"); };
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return maximum(node.right);
        }
    }


    public E removeMax() {
        E returnElement = maximum();
        root = removeMax(root);
        return returnElement;
    }

    private Node removeMax(Node node) {
        // 终止条件
        if (node.right == null) {
            Node leftNode = node.left;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public E minimum() {
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left != null) {
            return minimum(node.left);
        } else {
            return node;
        }
    }

    public E removeMin() {
        E minElement = minimum();
        root = removeMin(root);
        return minElement;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            size --;
            return rightNode;
        }
        node = removeMin(node.left);
        return node;
    }


    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) > 0) { // 如果待删除节点比当前节点大
            node.right = remove(node.right, e);
            return node;
        } else if (e.compareTo(node.e) < 0){ // 小于
            node.left = remove(node.left, e);
            return node;
        } else { // 等于
            // 如果待删除节点等于当前节点
            // 找到当前节点右继节点
            Node successor = new Node(node.right.e);
            successor.left = node.left;
            successor.right = removeMin(node.right);
            return successor;
        }
    }

    // 前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDeepString(depth) + "null\n");
            return;
        }
        res.append(generateDeepString(depth) + node.e + '\n');
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDeepString(int depth) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println("hhh");
        BST<Integer> bst = new BST<>();
        //
        //       5
        //      / \
        //     3   6
        //    / \   \
        //   2   4   8
        //
        int[] nums = { 5, 3, 6, 8 ,4 ,2 };

        for (int num : nums) {
            bst.add(num);
        }
        bst.preOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.postOrder();
        System.out.println(bst);


    }
}
