class Test {
    public static void main(String[] args) {
        int[] input = {2,1,1,3,2,3,4,5,6,7,8,9};
        FenwickTree tree = new FenwickTree(input);
        System.out.println(tree);
        tree.update(11, 8);
        System.out.println(tree);
        System.out.println(tree.getSum(11));
    }
}
