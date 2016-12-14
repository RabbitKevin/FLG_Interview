var countBattleships = function(board) {
    let row = board.length;
    let col = board[0].length;
    let map = [];
    for(let i = 0; i < row; ++i) {
        map.push(Array(col));
    }
    //---------------------------//
    let count = 0;
    for(let i = 0; i < row; ++i) {
        for(let j = 0; j < col; ++j) {
            if(map[i][j] || board[i][j] === '.') continue;
            dfs(board, map, i, j);
            count++;
        }
    }
    return count;
    function dfs(board, map, row, col) {
        if(row < 0 || row === board.length || col < 0 || col === board[0].length || board[row][col] === '.' || map[row][col]) return;
        map[row][col] = true;
        dfs(board, map, row-1, col);
        dfs(board, map, row+1, col);
        dfs(board, map, row, col-1);
        dfs(board, map, row, col+1);
    }
};
