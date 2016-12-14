var fizzBuzz = function(n) {
    let arr = Array(n);
    for(let i = 1; i <= n; ++i) {
        let num = `${i}`;
        if(!(num%15)) num = 'FizzBuzz';
        else if(!(num%3)) num = 'Fizz';
        else if(!(num%5)) num = 'Buzz';
        arr[i-1] = num;
    }
    return arr;
};
