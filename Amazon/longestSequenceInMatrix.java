class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,5,3}, {1,2,3,4},{2,4,6,4},{4,1,2,3}};
        int length = findLongest(matrix);
        System.out.println(length);
    }
    public static int findLongest(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[0].length; ++j) {
                if(result[i][j] == 0)dfs(i,j,Integer.MIN_VALUE, result, matrix);
                max = Math.max(result[i][j], max);
            }
        }
        for(int[] nums : result) {
            for(int i : nums) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        return max;
    }
    private static int dfs(int i, int j, int last, int[][] result, int[][] matrix) {
        if(i < 0 || i == matrix.length || j < 0 || j == matrix[0].length || last >= matrix[i][j]) return 0;
        if(result[i][j] != 0) return result[i][j];
        int up = dfs(i-1, j, matrix[i][j], result, matrix);
        int down = dfs(i+1, j, matrix[i][j], result, matrix);
        int left = dfs(i, j-1, matrix[i][j], result, matrix);
        int right = dfs(i, j+1, matrix[i][j], result, matrix);
        int tmp = Math.max(Math.max(up, down), Math.max(left,right));
        result[i][j] = tmp+1;
        return result[i][j];
    }
}
