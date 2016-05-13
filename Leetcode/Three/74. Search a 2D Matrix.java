public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        if(row == -1) return false;
        return findNum(matrix[row], target);
    }
    private int findRow(int[][] matrix, int target) {
        if(matrix.length == 0) return -1;
        int row = matrix.length;
        int col = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[row-1][col-1]) return -1;
        int left = 0;
        int right = row-1;
        int mid = (left+right) >> 1;
        while(left <= right) {
            if(target >= matrix[mid][0] && target <= matrix[mid][col-1]) return mid;
            else if(target < matrix[mid][0]) right = mid-1;
            else left = mid+1;
            mid = (left+right) >> 1;
        }
        return -1;
    }
    private boolean findNum(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = (left+right) >> 1;
            if(nums[mid] == target) return true;
            else if(nums[mid] > target) right = mid-1;
            else left = mid+1;
        }
        return false;
    }
}
