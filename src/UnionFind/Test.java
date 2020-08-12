package UnionFind;

import java.util.Random;

public class Test {

    private static double testUF(UF uf, int m) {
        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();

        for (int i = 0; i < m; i ++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);

            // m次合并操作
            uf.unionElements(a, b);
        }

        for (int i = 0; i < m; i ++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);

            // m次查询操作
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 100000000.0;
    }

    public static void main(String [] args) {
        int size = 100000;
        int m = 100000;

        UnionFind unionFind = new UnionFind(size);

        UnionFind2 unionFind2 = new UnionFind2(size);

        System.out.println("unionFind time: " + testUF(unionFind, m) + 's');
        System.out.println("unionFind2 time: " + testUF(unionFind2, m) + 's');
    }
}
