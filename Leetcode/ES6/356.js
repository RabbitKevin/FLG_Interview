var isReflected = function(points) {
    let min = Number.POSITIVE_INFINITY;
    let max = Number.NEGATIVE_INFINITY;
    let map = {};
    points.forEach((point)=> {
        min = Math.min(point[0], min);
        max = Math.max(point[0], max);
        if(!map.hasOwnProperty(point[0])) {
            map[point[0]] = {
                [point[1]]:true
            };
        }
        else {
            let tmp = map[point[0]];
            if(!tmp.hasOwnProperty(point[1])) tmp[point[1]] = true;
        }
    });
    let mid = (min+max) / 2;
    let count = points.length;
    for(let i = 0; i < count; ++i) {
        let index = 2*mid-points[i][0];
        if(!map[index] || !map[index][points[i][1]]) return false;
    }
    return true;
};
