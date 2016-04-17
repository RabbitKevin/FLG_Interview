//Backtracking
var generateAbbreviations = function(word) {
    var result = [];
    if(!word) return [''];
    var sb = [];
    dfs(result, sb, word, 0, 0);
    return result;
};
function dfs(result, sb, strs, num, index) {
    if(index === strs.length) {
        result.push(sb.join('')+(num?String(num):''));
        return;
    }
    dfs(result, sb, strs, num+1, index+1);
    if(num)sb.push(num);
    sb.push(strs.charAt(index));
    dfs(result, sb, strs, 0, index+1);
    sb.pop();
    if(num)sb.pop();
}

//----Top down
var generateAbbreviations = function(word) {
    if(!word) return [''];
    if(word.length === 1) return [word, '1'];
    var words = generateAbbreviations(word.substring(0, word.length-1));
    var result = [];
    var size = words.length;
    for(var i = 0; i < size; ++i) {
        result.push(words[i]+word.charAt(word.length-1));
        result.push(transfer(words[i]));
    }
    return result;
};
function transfer(wd) {
    var index = wd.length-1;
    var code = wd.charCodeAt(index);
    while(index >= 0 && (code >= 48 && code <= 57)) {
        index--;
        code = wd.charCodeAt(index);
    }
    return wd.substring(0, index+1)+(index === wd.length-1?'1':String(Number.parseInt(wd.substring(index+1))+1));
}

//----Bottom up
var generateAbbreviations = function(word) {
    if(!word) return [''];
    var bfe = [word.charAt(0), '1'];
    for(var i = 1; i < word.length; ++i) {
        var cur = [];
        var letter = word.charAt(i);
        for(var j = 0; j < bfe.length; ++j) {
            cur.push(bfe[j]+letter);
            cur.push(transfer(bfe[j]));
        }
        bfe = cur;
    }
    return bfe;
};
function transfer(wd) {
    var index = wd.length-1;
    var code = wd.charCodeAt(index);
    while(index >= 0 && (code >= 48 && code <= 57)) {
        index--;
        code = wd.charCodeAt(index);
    }
    return wd.substring(0, index+1)+(index === wd.length-1?'1':String(Number.parseInt(wd.substring(index+1))+1));
}
