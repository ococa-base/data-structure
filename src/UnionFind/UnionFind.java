package UnionFind;

import MaxHeap.Array;

/**
 * 并查集
 */
public class UnionFind implements UF {

    // elements list
    private int [] ids;


    public UnionFind(int size) {
        ids = new int[size];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int qValue = find(q);
        int pValue = find(p);

        if (pValue == qValue) {
            return;
        }

        for (int i = 0; i < ids.length; i ++) {
            if (find(ids[i]) == qValue) {
                ids[i] = pValue;
            }
        }
    }

    // find elements p correspond position
    private int find(int p) {
        if (p < 0 || p >= ids.length) {
            throw new IllegalArgumentException("argument over limits");
        }
        return ids[p];
    }

    @Override
    public int getSize() {
        return ids.length;
    }
}
