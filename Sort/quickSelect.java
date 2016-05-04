class Solution {
    public static void main(String[] args) {
        int[] nums = {3,5,2,6,4,9,20};//2 3 4 5 6 9 20
        int num = quickSelect(nums, 0, nums.length-1, 2);
        System.out.println(num);
    }
    public static int quickSelect(int[] nums, int lo, int hi, int k) {
        int i = lo;
        int j = hi+1;
        int pivot = nums[lo];
        while(i < j) {
            while(nums[++i] < pivot) {
                if(i == hi) break;
            }
            while(nums[--j] > pivot);
            if(i < j) swap(nums, i, j);
        }
        swap(nums, lo, j);
        if(j-lo == k-1) return nums[j];
        else if(j-lo < k-1) return quickSelect(nums, j+1, hi, k-(j-lo+1));
        else return quickSelect(nums, lo, j-1, k);
    }
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
