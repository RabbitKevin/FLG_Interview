/*
    Rotating Sum path
*/
var minPathSum = function(grid) {
    var m = grid.length;
    if(!m) return 0;
    var n = grid[0].length;
    var buffer = [];
    for(var i = 0; i < 2; ++i) {
        var row = [];
        for(var j = 0; j < n; ++j) {
            row.push(0);
        }
        buffer.push(row);
    }
    //-----------------------------//
    buffer[0][0] = grid[0][0];
    var ptr = 0;
    for(j = 0; j < m; ++j) {
        var prev = buffer[ptr^1];
        var cur = buffer[ptr];
        for(i = 0; i < n; ++i) {
            if(!i && !j) continue;
            var top = j > 0?prev[i]:Number.POSITIVE_INFINITY;
            var left = i > 0?cur[i-1]:Number.POSITIVE_INFINITY;
            cur[i] = Math.min(top, left)+grid[j][i];
        }
        ptr^=1;
    }
    return cur[n-1];
};
