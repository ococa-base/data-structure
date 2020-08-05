package SegmentTree;


public class SegmentTree<E> {

    private E[] data; // 存储元数据
    private E[] tree; // 存储线段树

    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;

        data = (E [])new Object[arr.length];
        System.arraycopy(arr, 0, data, 0, arr.length);

        tree = (E [])new Object[4 * arr.length];
        buildSegmentTree(0, 0, arr.length - 1);

    }

    // 在treeIndex的位置创建表示区间[left, right]的线段树
    private void buildSegmentTree(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex); // 左子树的索引
        int rightTreeIndex = rightChild(treeIndex); // 右子树的索引

        int mid = left + (right - left) / 2;

        buildSegmentTree(leftTreeIndex, left, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, right);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    };

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("arguments index should > 0 <= data.length");
        }
        return data[index];
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');

        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                res.append(tree[i]);
            } else {
                res.append("null");
            }
            if (i != tree.length - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }


}
