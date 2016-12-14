/*
    Math solution
*/
var numberOfArithmeticSlices = function(A) {
    let count = 0;
    let i = 0;
    let j = 1;
    while(j < A.length) {
        let gap = A[j]-A[i];
        while(j < A.length && A[j]-A[j-1] === gap) {
            j++;
        }
        count+=help(j-i);
        i = j-1;
    }
    return count;
};

function help(size) {
    let count = 0;
    for(let i = 3; i <= size; ++i) {
        for(let j = 0; j+i <= size; ++j) {
            count++;
        }
    }
    return count;
}

/*
    DP solution
*/
var numberOfArithmeticSlices = function(A) {
    if(A.length < 3) return 0;
    let dp = [];
    let count = 0;
    dp.push(1);
    dp.push(2);
    for(let i = 2; i < A.length; ++i) {
        let val = (A[i]-A[i-1] === A[i-1]-A[i-2])?dp[dp.length-1]+1:2;
        count+=val-2;
        dp.push(val);
    }
    return count;
};
