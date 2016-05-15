public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        int sum = numbers[left]+numbers[right];
        int[] result = new int[2];
        while(sum != target) {
            if(sum > target) {//move right to <= target
                right = getIndexSmall(numbers, left+1, right-1, target-numbers[left]);
            }
            else {
                left = getIndexLarge(numbers, left+1, right-1, target-numbers[right]);
            }
            sum = numbers[left]+numbers[right];
        }
        result[0] = left+1;
        result[1] = right+1;
        return result;
    }
    private int getIndexSmall(int[] nums, int left, int right, int target) {
        while(left < right) {
            int mid = (left+right) >> 1;
            if(nums[mid] <= target) {
                if(nums[mid+1] > target) return mid;
                else left = mid+1;
            }
            else right = mid-1;
        }
        return left;
    }
    private int getIndexLarge(int[] nums, int left, int right, int target) {
        while(left < right) {
            int mid = (left+right) >> 1;
            if(nums[mid] >= target) right = mid;
            else left = mid+1;
        }
        return left;
    }
}
