/*
    sliding window
*/
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = nums.length;
        while(right < nums.length) {
            while(right < nums.length && sum < s) {
                sum+=nums[right++];
            }
            while(sum >= s) {
                sum-=nums[left++];
            }
            min = Math.min(right-left+1, min);
        }
        if(right-left == nums.length) return 0;
        return min;
    }
}

/*
    Binary search
*/
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int[] sums = new int[nums.length+1];
        for(int i = 0; i < nums.length; ++i) {
            sums[i+1] = sums[i]+nums[i];
        }
        //------------------------------------//
        int max = nums.length+1;
        for(int i = 0; i < sums.length; ++i) {
            int index = getIndex(sums, i+1, sums[i]+s);
            if(index == -1) continue;
            else {
                max = Math.min(index-i, max);
            }
        }
        return max == nums.length+1?0:max;
    }
    private int getIndex(int[] sum, int start, int target) {
        int left = start;
        int right = sum.length-1;
        if(target > sum[right]) return -1;
        while(left < right) {
            int mid = (left+right) >> 1;
            if(sum[mid] == target) return mid;
            if(sum[mid] < target) left = mid+1;
            else right = mid;
        }
        return left;
    }
}
