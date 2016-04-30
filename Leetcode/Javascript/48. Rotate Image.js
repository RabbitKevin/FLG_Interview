var rotate = function(matrix) {
    //-----diagonal-----//
    var row = matrix.length;
    if(!row) return;
    //-----diagonal-----//
    for(var i = 0; i < row-1; ++i) {
        for(var j = 0; j < row-1-i; ++j) {
            var tmp = matrix[i][j];
            matrix[i][j] = matrix[row-1-j][row-1-i];
            matrix[row-1-j][row-1-i] = tmp;
        }
    }
    //------------------//
    for(i = 0; i < (row >> 1);++i) {
        for(j = 0; j < row; ++j) {
            tmp = matrix[i][j];
            matrix[i][j] = matrix[row-1-i][j];
            matrix[row-1-i][j] = tmp;
        }
    }
};
