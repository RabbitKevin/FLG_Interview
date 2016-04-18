var uniquePaths = function(m, n) {
    if(!m || !n) return 0;
    var buffer = [];
    for(var i = 0; i < 2; ++i) {
        var line = [];
        for(var j = 0; j < n; ++j) {
            line.push(0);
        }
        buffer.push(line);
    }
    buffer[1][0] = 1;
    var cur = 1;
    for(i = 0; i < m; ++i) {
        var cur_row = buffer[cur];
        var bfe_row = buffer[cur^1];
        for(j = 0; j < n;++j) {
            if(!i && !j) continue;
            cur_row[j] = bfe_row[j]+(j?cur_row[j-1]:0);
        }
        cur = cur ^ 1;
    }
    return buffer[cur^1][n-1];
};
//js的运算符优先级迷之诡异.......
