/*
    Fenwick Tree的解法
*/
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int[] cand = new int[nums.length+1];
        cand[0] = Integer.MIN_VALUE;//as root
        for(int i = 1; i <= nums.length; ++i) {
            cand[i] = nums[i-1];
        }
        Arrays.sort(cand);
        //----------------//
        int[] bit = new int[cand.length];//Fenwick Tree
        //Record # of elements from 0~nums[i]
        for(int i = 0; i < nums.length; ++i) {
            int index = Arrays.binarySearch(cand, nums[i]);
            addValue(bit, 1, index);
        }
        //-------------------------------------------------//
        //For each elements for query, all those elements occur before it has been deleted
        for(int i = 0; i < nums.length; ++i) {
            int j = Arrays.binarySearch(cand, nums[i]);
            result.add(getSum(bit, j-1));
            addValue(bit, -1, j);
        }
        return result;
    }
    private void addValue(int[] bit, int val, int index) {
        while(index < bit.length) {
            bit[index]+=val;
            index += index & -index;
        }
    }
    private int getSum(int[] bit, int index) {
        int sum = 0;
        while(index > 0) {
            sum+=bit[index];
            index -= index & -index;
        }
        return sum;
    }
}
/*
    D&C解法
*/
