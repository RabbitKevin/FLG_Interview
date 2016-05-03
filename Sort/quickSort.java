class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{3,8,2,8,6,1,9,6};
        quickSort(nums, 0, nums.length-1);
        for(int num : nums) {
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println();
    }
    public static void quickSort(int[] nums, int i, int j) {
        if(i >= j) return;
        int index = partition(nums, i, j);
        quickSort(nums, i, index-1);
        quickSort(nums, index+1, j);
    }
    private static int partition(int[] nums, int lo, int hi) {
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
        swap(nums, j, lo);
        return j;
    }
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
