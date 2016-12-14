var findMinArrowShots = function(points) {
    points.sort((a,b) => {
        return a[1]-b[1];
    });
    //--------------------//
    let sum = 0;
    for(let i = 0; i < points.length;) {
        let start = points[i];
        let range = [start[0], start[1]];
        let j = i;
        while(j < points.length && points[j][0] <= range[1]) {
            range[0] = Math.max(points[j][0], range[0]);
            j++;
        }
        sum++;
        i = j;
    }
    return sum;
};
