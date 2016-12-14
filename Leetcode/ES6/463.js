var islandPerimeter = function(grid) {
    let getNeighborNum = (grid, i, j) => {
        let count = 4;
        if(i-1 >= 0 && j < grid[0].length && grid[i-1][j] === 1) count--;
        if(i+1 < grid.length && j < grid[0].length && grid[i+1][j] === 1) count--;
        if(i < grid.length && j+1 < grid[0].length && grid[i][j+1] === 1) count--;
        if(i < grid.length && j-1 >= 0 && grid[i][j-1] === 1) count--;
        return count;
    };
    let sum = 0;
    for(let i = 0; i < grid.length; ++i) {
        for(let j = 0; j < grid[0].length; ++j) {
            if(grid[i][j] === 1) sum+=getNeighborNum(grid, i, j);
        }
    }
    return sum;
};
