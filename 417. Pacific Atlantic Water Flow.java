public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        int row = matrix.length;
        if(row == 0) return result;
        int col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        boolean[][] isReached = new boolean[row][col];
        for(int i = 0; i < row; ++i) {
            dfs(matrix, isReached, pacific, i, 0, Integer.MIN_VALUE, result);
            dfs(matrix, isReached, atlantic, i, col-1, Integer.MIN_VALUE, result);
        }
        for(int j = 0; j < col; ++j) {
            dfs(matrix, isReached, pacific, 0, j, Integer.MIN_VALUE, result);
            dfs(matrix, isReached, atlantic, row-1, j, Integer.MIN_VALUE, result);
        }
        return result;
    }
    private void dfs(int[][] matrix, boolean[][] isReached, boolean[][] isVisited, int x, int y, int last, List<int[]> result) {
        if(x < 0 || y < 0 || x == matrix.length || y == matrix[0].length || isVisited[x][y] || matrix[x][y] < last) return;
        if(isReached[x][y]) {
            int[] tmp = new int[2];
            tmp[0] = x;
            tmp[1] = y;
            result.add(tmp);
        }
        else isReached[x][y] = true;
        isVisited[x][y] = true;
        dfs(matrix, isReached, isVisited, x-1, y, matrix[x][y], result);
        dfs(matrix, isReached, isVisited, x+1, y, matrix[x][y], result);
        dfs(matrix, isReached, isVisited, x, y-1, matrix[x][y], result);
        dfs(matrix, isReached, isVisited, x, y+1, matrix[x][y], result);
    }
}
