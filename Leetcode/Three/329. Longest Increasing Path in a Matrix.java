public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        if(row == 0) return 0;
        int col = matrix[0].length;
        int[][] path = new int[row][col];
        int max = 0;
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
                if(path[i][j] == 0) {
                    max = Math.max(max, dfs(i,j,matrix,path, Long.MIN_VALUE));
                }
            }
        }
        return max;
    }

    private int dfs(int i, int j, int[][] matrix, int[][] path, long last) {
        if(i < 0 || i == matrix.length || j < 0 || j == matrix[0].length || matrix[i][j] <= last) return 0;
        if(path[i][j] != 0) return path[i][j];
        last = (long) matrix[i][j];
        int one = dfs(i+1, j, matrix, path, last);
        int two = dfs(i-1, j, matrix, path, last);
        int three = dfs(i, j-1, matrix, path, last);
        int four = dfs(i, j+1, matrix, path, last);
        path[i][j] = Math.max(Math.max(one,two), Math.max(three, four))+1;
        return path[i][j];
    }
}
