class FenwickTree {
    int[] BinaryIndexTree;
    public FenwickTree(int[] nums) {
        BinaryIndexTree = constructTree(nums);
    }
    public void update(int num, int pos) {
        pos++;
        int val = num - BinaryIndexTree[pos];
        while(pos < BinaryIndexTree.length) {
            BinaryIndexTree[pos]+=val;
            pos+=(pos & (-pos));
        }
    }
    public int getSum(int pos) {
        pos++;
        int sum = 0;
        while(pos > 0) {
            sum+=BinaryIndexTree[pos];
            pos-=(pos & (-pos));
        }
        return sum;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int num : BinaryIndexTree) {
            sb.append(num);
            sb.append(' ');
        }
        return sb.toString();
    }
    /*
         @para int[] input number to help construct a binary index tree
    */
    private int[] constructTree(int[] nums) {
        int[] result = new int[nums.length+1];
        int sum = 0;
        for(int i = 1; i <= nums.length;i++) {
            sum+=nums[i-1];
            int parent = i - (i & (-i));
            result[i] = sum-result[parent];
        }
        return result;
    }
}
