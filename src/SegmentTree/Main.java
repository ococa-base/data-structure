package SegmentTree;

public class Main {


    public static void main(String[] args) {
        Integer[] nums = { -2, 0, 3, -5, 2, -1};

        SegmentTree<Integer> segmentTree = new SegmentTree<Integer>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });

        SegmentTree<Integer> segmentTree1 = new SegmentTree<Integer>(nums, (a, b) -> a + b);

        System.out.println("--tree--" + segmentTree);
        System.out.println("--tree2--" + segmentTree);
    }
}
