/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    var count = 0;
    for(var i = 0; i < grid.length; ++i) {
        for(var j = 0; j < grid[0].length; ++j) {

            if(grid[i][j] <= 0) continue;
            dfs(i,j,grid);
            count++;
        }
    }
    return count;
};

function dfs(i, j, grid) {
    if(i < 0 || j < 0 || i == grid.length || j == grid.length || grid[i][j] <= 0) return;
    grid[i][j] = -1;
    dfs(i-1, j, grid);
    dfs(i+1, j,grid);
    dfs(i, j-1, grid);
    dfs(i, j+1, grid);
}
/*
    Js的test case有问题...似乎不是按照2D-grid的方式来写的
*/
