package MaxHeap;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<E>(capacity);
    }

    public MaxHeap() {
        data = new Array<E>();
    }

    // 返回堆中元素的个数
    public int getSize() {
        return data.getSize();
    }

    //
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中 一个索引表示的元素的父亲节点的索引
    public int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }

        return (index - 1) / 2;
    }

    public int leftChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }

    // 向堆中添加元素。 sift up（上浮）
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 &&  data.get(k).compareTo(data.get(parent(k))) > 0) { // 如果当前节点比父节点大 ，交换
            data.swap(k, parent(k));
            k = parent(k);
            // siftUp(k);
        }
    }


    public E removeMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("this is an empty array");
        }
        E max = data.get(0);

        data.swap(0, data.getSize() - 1);
        data.set(0, data.get(data.getSize() - 1));

        siftDown(0);
        return max;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) { // leftChild 在范围内
            int l = leftChild(k);

            if (l + 1 < data.getSize()   // rightChild 在范围内
                 && data.get(l + 1).compareTo(data.get(l)) > 0) { // 右子节点大于左子节点
                l = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(l)) >= 0) { // 如果当前节点大于子节点
                break;
            } else {
                data.swap(k, l);
            }
        }
    }

    private E findMax() {
        if (data.getSize() <= 0) {
            throw new IllegalArgumentException("data size is illegal");
        }
        return data.get(0);
    }

    // 取出最大元素 并用e替换
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    // 将任意数组转换成堆
    public void heapify(Array array) {
        for (int i = 0 ; i < array.getSize() ; i ++ ) {

        }
    }
}
