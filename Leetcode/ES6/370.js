var getModifiedArray = function(length, updates) {
    let sum = [];
    for(let i = 0; i <= length; ++i) {
        sum.push(0);
    }
    //-------------------------------//
    updates.forEach((update)=>{
        sum[update[0]]+=update[2];
        sum[update[1]+1]-=update[2];
    });
    let res = [];
    let total = 0;
    for(let i = 0; i < length; ++i) {
        total+=sum[i];
        res.push(total);
    }
    return res;
};
