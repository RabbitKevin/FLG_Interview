var depthSumInverse = function(nestedList) {
    let sum = 0,
        weighted = 0;
    let list =nestedList;
    while(list.length) {
        let next = [];
        let length = list.length;
        for(let i = 0; i < length; ++i){
            let cur = list[i];
            if(cur.isInteger()) weighted+=cur.getInteger();
            else {
                let tmp = cur.getList();
                let nestSize = tmp.length;
                for(let j = 0; j < nestSize; ++j) {
                    next.push(tmp[j]);
                }
            }
        }
        list = next;
        sum+=weighted;
    }
    return sum;
};
