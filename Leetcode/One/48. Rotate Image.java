class Solution {
    public void rotate(int[][] matrix) {
        //up down
        int height = matrix.length,
            width = matrix[0].length;
        int halfHeight = height >> 1;
        for(int i = 0; i < halfHeight; ++i) {
            for(int j = 0; j < width; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[height-1-i][j];
                matrix[height-1-i][j] = tmp;
            }
        }
        //left diag
        for(int i = 0; i < height; ++i) {
            for(int j = i; j < width; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
