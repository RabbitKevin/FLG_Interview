var minMutation = function(start, end, bank) {
    let dic = {};
    let letterArr = ['A','C','G','T'];
    bank.forEach((str) => {
        dic[str] = true;
    });
    let depth = 0;
    let queue = [];
    queue.push(start);
    if(dic.hasOwnProperty(start)) delete dic[start];
    while(queue.length) {
        let nextLayer = [];
        for(let n = 0; n < queue.length; ++n) {
            let str = queue[n];
            let strArr = str.split('');
            for(let i = 0; i < strArr.length; ++i) {
                let localCopy = strArr[i];
                for(let j = 0; j < 4; ++j) {
                    if(localCopy === letterArr[j]) continue;
                    strArr[i] = letterArr[j];
                    let nextStr = strArr.join('');
                    if(dic.hasOwnProperty(nextStr)) {
                        nextLayer.push(nextStr);
                        delete dic[nextStr];
                        if(nextStr === end) return depth+1;
                    }
                }
                strArr[i] = localCopy;
            }
        }
        queue = nextLayer;
        depth++;
    }
    return -1;
};
