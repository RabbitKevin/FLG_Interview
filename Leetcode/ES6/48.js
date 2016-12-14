var rotate = function(matrix) {
    let n = matrix.length;
    if(!n) return;
    //step one
    let swap = (matrix, i, j, x, y) => {
        let tmp = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = tmp;
    }
    for(let i = 0; i < n; ++i) {
        for(let j = 0; j < n-i; ++j) {
            swap(matrix, i, j, n-1-j, n-1-i);
        }
    }
    //-------------------------------//
    let mid = n >> 1;
    for(let i = 0; i < mid; ++i) {
        for(let j = 0; j < n; ++j) {
            swap(matrix, i, j, n-1-i, j);
        }
    }
};
