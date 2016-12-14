var letterCombinations = function(digits) {
    if(!digits.length) return [];
    let dic = [
        [''],
        [''],
        ['a','b','c'],
        ['d', 'e', 'f'],
        ['g', 'h', 'i'],
        ['j', 'k', 'l'],
        ['m', 'n', 'o'],
        ['p', 'q', 'r', 's'],
        ['t', 'u', 'v'],
        ['w', 'x', 'y', 'z']
        ];
    let cur = [];
    let res = [];
    dfs(digits, 0, dic, cur, res);
    return res;
};

function dfs(digits, index, dic, cur, res) {
    if(index === digits.length) {
        res.push(cur.join(''));
        return;
    }
    let pos = digits.charCodeAt(index)-48;
    let next = dic[pos];
    next.forEach((letter) => {
        cur.push(letter);
        dfs(digits, index+1, dic, cur, res);
        cur.pop();
    });
}
