package UnionFind;

public class UnionFind2 implements UF {

    private int [] parents;

    public UnionFind2(int size) {
        parents = new int[size];

        for (int i = 0; i < size; i++) {
            parents[i] = i;
        }
    }

    // 查询p和q是否属于同一集合
    // O（h）时间复杂度
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 合并q元素和p元素所属的集合
    // O（h）复杂度，h为树的高度
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        } else {
            parents[qRoot] = pRoot;
        }
    }

    @Override
    public int getSize() {
        return parents.length;
    }

    private int find(int p) {
        if (p < 0 || p >= parents.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        if (parents[p] == p) {
            return p;
        } else {
            return find(parents[p]);
        }
    }
}
