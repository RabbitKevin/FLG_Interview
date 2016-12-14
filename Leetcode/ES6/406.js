var reconstructQueue = function(people) {
    people.sort((a,b) => {
        if(a[0] === b[0]) return a[1]-b[1];
        else return b[0]-a[0];
    });
    let res = [];
    people.forEach((pair)=>{
        let index = pair[1];
        if(index >= res.length) res.push(pair);
        else {
            let prev = pair;
            for(let j = index; j < res.length; ++j) {
                let tmp = res[j];
                res[j] = prev;
                prev = tmp;
            }
            res.push(prev);
        }
    });
    return res;
};
