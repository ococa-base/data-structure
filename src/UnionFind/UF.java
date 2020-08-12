package UnionFind;

public interface UF {

    // 查询两个节点是否连接
    boolean isConnected(int p, int q);

    // 连接两个元素
    void unionElements(int p, int q);

    int getSize();

//    int [] connected(int p, int q);
}
