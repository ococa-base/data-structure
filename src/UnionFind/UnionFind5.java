package UnionFind;

/**
 * 并查集（路径压缩，每次查询 压缩树的高度）
 */
public class UnionFind5 implements UF {

    private int [] parents;
    private int [] rank; // size[i] 表示以i为根的集合 对应的深度

    public UnionFind5(int size) {
        parents = new int[size];
        this.rank = new int[size];

        for (int i = 0; i < size; i++) {
            parents[i] = i;
            this.rank[i] = 1;
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
        }

        // 根据两个元素的所在树的元素的个数不同判断合并的方向，
        // 将元素个数少的集合合并到元素个数多的集合上面
        // p节点深度大于q节点，q的根节点指向p节点根节点
        if (rank[qRoot] < rank[pRoot]) {
            parents[qRoot] = pRoot;
        } else if (rank[pRoot] < rank[qRoot] ){
            parents[pRoot] = qRoot;
        } else { // rank[qRoot] == rank[pRoot]
            parents[pRoot] = qRoot;
            rank[qRoot] += 1;
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
            parents[p] = parents[parents[p]];
            return find(parents[p]);
        }
    }
}
