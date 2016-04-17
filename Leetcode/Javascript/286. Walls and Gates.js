var wallsAndGates = function(rooms) {
    var INF = Math.abs(1 << 31)-1;
    var row = rooms.length;
    if(!row) return;
    var col = rooms[0].length;
    //------------------------------------------//
    var queue = [];
    for(i = 0; i < row; ++i) {
        for(j = 0; j < col;++j) {
            if(!rooms[i][j]) queue.push([i, j]);
        }
    }
    //------------------------------------------//
    var depth = 1;
    while(queue.length) {
        var next = [];
        while(queue.length) {
            var point = queue.shift();
            //up
            if(point[0]-1 >= 0 && rooms[point[0]-1][point[1]] === INF) {
                next.push([point[0]-1, point[1]]);
                rooms[point[0]-1][point[1]] = depth;
            }
            //left
            if(point[1]-1 >= 0 && rooms[point[0]][point[1]-1] === INF) {
                next.push([point[0], point[1]-1]);
                rooms[point[0]][point[1]-1] = depth;
            }
            //down
            if(point[0]+1 < row && rooms[point[0]+1][point[1]] === INF) {
                next.push([point[0]+1, point[1]]);
                rooms[point[0]+1][point[1]] = depth;
            }
            //right
            if(point[1]+1 < col && rooms[point[0]][point[1]+1] === INF) {
                next.push([point[0], point[1]+1]);
                rooms[point[0]][point[1]+1] = depth;
            }
        }
        queue = next;
        depth++;
    }
};
