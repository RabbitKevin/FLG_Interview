/*
    解法1: D&C
    做法类似于merge sort.
    其实就是对merge sort进行剪枝，需要k个数，那么sub_left 和sub_right各自最多需要k个数.
    当K >= nums.length/2时，几乎与merge sort无区别(最后一次merge有点区别)
*/
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] result = help(nums, 0, nums.length-1, k);
        return result[k-1];
    }
    private int[] help(int[] nums, int i , int j, int k) {
        if(i == j) return new int[]{nums[i]};
        int mid = (i+j) >> 1;
        int[] left = help(nums, i, mid, k);
        int[] right = help(nums, mid+1, j, k);
        int size = Math.min(k, left.length+right.length);
        int[] result = new int[size];
        //----------------merge------------------------//
        i = 0;
        j = 0;
        for(int n = 0; n < size; ++n) {
            if(i == left.length) result[n] = right[j++];
            else if(j == right.length) result[n] = left[i++];
            else {
                if(left[i] <= right[j]) result[n] = right[j++];
                else result[n] = left[i++];
            }
        }
        return result;
    }
}
/*
    解法2: PQ

*/
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int num : nums) {
            pq.add(num);
        }
        for(int i = 0; i < nums.length-k; ++i) {
            pq.poll();
        }
        return pq.poll();
    }
}
