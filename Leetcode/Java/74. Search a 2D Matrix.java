public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //-----choose row------//
        if(matrix.length == 0) return false;
        int right = matrix.length-1;
        int col = matrix[0].length-1;
        if(target < matrix[0][0] || target > matrix[right][col]) return false;
        int row = findRow(matrix, target);
        if(target < matrix[row][0] || target > matrix[row][col]) return false;
        //--------------------------------------------------------------------//
        return binarySearch(matrix[row], target);
    }
    private int findRow(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length-1;
        int col = matrix[0].length-1;
        while(left < right) {
            int mid = (left+right)/2;
            if(target < matrix[mid][0]) right = mid-1;
            else if( target > matrix[mid][col]) left = mid+1;
            else return mid;
        }
        return left;
    }
    private boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = (left+right)/2;
            if(nums[mid] == target) return true;
            else if(nums[mid] < target) left = mid+1;
            else right = mid-1;
        }
        return false;
    }
}
