var validWordAbbreviation = function(word, abbr) {
    if(!abbr.length) return word.length === 0;
    let i = 0,
        n = 0;
    while(i < abbr.length && n < word.length) {
        let j = i;
        let num = 0;
        if(abbr[j] === '0') return false;
        while(j < abbr.length && isDigit(abbr[j])) {
            num = num*10+(abbr[j].charCodeAt(0)-48);
            j++;
        }
        if(i === j) {//non number
            if(word[n] !== abbr[j]) return false;
            else {
                n++;
                i++;
            }
        }
        else {
            n+=num;
            i = j;
        }
    }
    return n === word.length && i === abbr.length;
};

function isDigit(str) {
    let num = str.charCodeAt(0);
    return num >= 48 && num <= 57;
}
