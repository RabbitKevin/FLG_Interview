/*
    二分＋剪枝
    log(n)*log(m);
*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        return search2D(matrix, 0, 0, matrix.length-1, matrix[0].length-1, target);
    }
    private boolean search2D(int[][] matrix, int row_up, int col_up, int row_down, int col_down, int target) {
        if(row_up > row_down || col_up > col_down) return false;
        if(target < matrix[row_up][col_up] || target > matrix[row_down][col_down]) return false;//not in this range
        int row_mid = (row_up+row_down)/2;
        int col_mid = (col_up+col_down)/2;
        boolean two = search2D(matrix, row_mid+1, col_up, row_down, col_mid, target);
        if(two) return true;
        boolean three = search2D(matrix, row_up, col_mid+1, row_mid, col_down, target);
        if(three) return true;
        if(target == matrix[row_mid][col_mid]) return true;
        else if(target < matrix[row_mid][col_mid]) return search2D(matrix, row_up, col_up, row_mid, col_mid, target);
        else return search2D(matrix, row_mid+1, col_mid+1, row_down, col_down, target);
    }
}

/*
    O(n+m)
    Linear
*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int n = 0;
        int m = matrix[0].length-1;
        while(n < matrix.length && m >= 0) {
            if(matrix[n][m] == target) return true;
            else if(matrix[n][m] < target) n++;
            else m--;
        }
        return false;
    }
}
