class Solution {
    public int numIslands(char[][] grid) {
        int height = grid.length;
        if(height == 0) return 0;
        int res = 0;
        int width = grid[0].length;
        for(int i = 0; i < height; ++i) {
            for(int j = 0; j < width; ++j) {
                if(!isLand(grid[i][j])) continue;
                dfs(grid, i, j);
                res++;
            }
        }
        return res;
    }
    private void dfs(char[][] grid, int x, int y) {
        int height = grid.length,
            width = grid[0].length;
        if(x < 0 || x == height || y < 0 || y == width || !isLand(grid[x][y])) return;
        grid[x][y] = '0';
        dfs(grid, x-1, y);
        dfs(grid, x+1, y);
        dfs(grid, x, y-1);
        dfs(grid, x, y+1);
    }
    private boolean isLand(char cell) {
      return cell == '1';
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int height = grid.length;
        if(height == 0) return 0;
        int res = 0;
        int width = grid[0].length;
        for(int i = 0; i < height; ++i) {
            for(int j = 0; j < width; ++j) {
                if(!isLand(grid[i][j])) continue;
                bfs(grid, i, j);
                res++;
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int x, int y) {
        Queue<Character> queue = new LinkedList<>();
        int height = grid.length,
            width = grid[0].length;
        for(int i = 0; i < height; ++i) {
            for(int j = 0; j < width; ++j) {

            }
        }
    }

    private boolean isLand(char cell) {
      return cell == '1';
    }
}
