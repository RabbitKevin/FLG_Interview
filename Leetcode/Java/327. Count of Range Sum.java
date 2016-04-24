/*
    https://leetcode.com/discuss/79907/summary-divide-conquer-based-binary-indexed-based-solutions
    慢慢领悟精神...
*/
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length+1];
        long[] cand = new long[3*sum.length+1];
        int index = 0;
        cand[index++] = sum[0];
        cand[index++] = sum[0]+lower-1;
        cand[index++] = sum[0]+upper;
        for(int i = 1; i < sum.length; ++i) {
            sum[i] = nums[i-1]+sum[i-1];
            cand[index++] = sum[i];
            cand[index++] = sum[i]+lower-1;
            cand[index++] = sum[i]+upper;
        }
        cand[index] = Long.MIN_VALUE;
        Arrays.sort(cand);
        //-----------------------------------//
        int[] bit = new int[cand.length];
        for(int i = 0; i < sum.length; ++i) {
            addValue(bit, 1, Arrays.binarySearch(cand, sum[i]));
        }
        int count = 0;
        for(int i = 1; i < sum.length; ++i) {
            addValue(bit, -1, Arrays.binarySearch(cand, sum[i-1]));
            count-=getSum(bit, Arrays.binarySearch(cand, sum[i-1]+lower-1));
            count+=getSum(bit, Arrays.binarySearch(cand, sum[i-1]+upper));
        }
        return count;
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
