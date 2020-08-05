package MaxHeap;

import java.util.Random;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap() {
        data = new Array<E>();
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     *    0
     *   1 2
     * 3 4 5 6
     *
     */
    // 获取index节点父节点index
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1)/ 2;
    }

    // 获取index节点左子节点index
    public int leftChild(int index) {
        return index * 2 + 1;
    }

    // 获取index节点右子节点index
    public int rightChild(int index) {
        return index * 2 + 2;
    }

    // 给堆中添加元素（上浮）
    public void add(E e) {
        // 1. 添加元素
        data.addLast(e);

        // 2. 调整元素的位置
        siftUp(data.getSize() - 1);

    }

    // 上浮索引位置为k的元素在堆中的位置 直到符合堆的定义
    private void siftUp(int k) {
        // k的父节点的值小于k的值
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            // 继续上浮直到k=0
            k = parent(k);
        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("can not find max when heap is empty");
        }
        return data.get(0);
    }

    // 取出堆中的最大元素
    public E extractMax() {
        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();

        siftDown(0);

        return ret;
    }

    private void siftDown(int k) {
       while (data.getSize() > leftChild(k)) {
           int j = leftChild(k); // j 代表左右两个中的最大值
           if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) { // 有右节点右 && 节点大于左节点
                j = rightChild(k);
           }

           if (data.get(k).compareTo(data.get(j)) >= 0) { // k > j 停止下沉
               break;
           }

           data.swap(k, j);
           k = j;

       }
    }

    public static void main(String [] args) {
        int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            // 每次取最大值 相当于排序
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n ; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("Test maxHeap completed");
    }
}