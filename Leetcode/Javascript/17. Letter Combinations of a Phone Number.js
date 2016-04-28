var letterCombinations = function(digits) {
    var result = [];
    if(!digits.length) return result;
    var dic = ['',' ','abc','def','ghi','jkl','mno','pqrs','tuv','wxyz'];
    dfs(0, digits, [], dic, result);
    return result;
};
function dfs(i, digits, list, dic, result) {
    if(i === digits.length) {
        result.push(list.join(''));
        return;
    }
    var num = Number.parseInt(digits.charAt(i));
    var candidate = dic[num];
    if(!candidate) dfs(i+1, digits, list, dic, result);
    for(var j = 0; j < candidate.length; ++j) {
        list.push(candidate.charAt(j));
        dfs(i+1, digits, list, dic, result);
        list.pop();
    }
}
